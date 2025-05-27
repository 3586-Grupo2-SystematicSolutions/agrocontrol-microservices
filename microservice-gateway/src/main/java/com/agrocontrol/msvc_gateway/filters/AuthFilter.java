package com.agrocontrol.msvc_gateway.filters;

import com.agrocontrol.msvc_gateway.dtos.TokenDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

@Component
public class AuthFilter implements GatewayFilter {

    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);
    private final WebClient.Builder webClientBuilder;
    private final WebClient directWebClient;

    public AuthFilter(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
        this.directWebClient = WebClient.builder().build(); // WebClient sin balanceador de carga
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders headers = exchange.getRequest().getHeaders();

        if (!headers.containsKey(HttpHeaders.AUTHORIZATION)) {
            logger.warn("Falta el header Authorization");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        String authHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            logger.warn("Token mal formado");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        String token = authHeader.substring(7);
        logger.info("Validando token: " + token);

        return webClientBuilder.build()
                .post()
                .uri("lb://msvc-iam/msvc-iam/api/v1/authentication/verify-token/" + token)
                .retrieve()
                .bodyToMono(TokenDto.class)
                .timeout(Duration.ofSeconds(10))
                .flatMap(authenticatedUser -> {
                    logger.info("Token válido. Continuando con la solicitud.");
                    return chain.filter(exchange);
                })
                .onErrorResume(TimeoutException.class, e -> {
                    logger.error("Timeout al validar el token", e);
                    exchange.getResponse().setStatusCode(HttpStatus.SERVICE_UNAVAILABLE);
                    return exchange.getResponse().setComplete();
                })
                .onErrorResume(e -> {
                    if (e instanceof WebClientResponseException webClientException) {
                        HttpStatus statusCode = (HttpStatus) webClientException.getStatusCode();
                        if (statusCode == HttpStatus.SERVICE_UNAVAILABLE) {
                            logger.error("El servicio de autenticación no está disponible (503).");
                        } else {
                            logger.error("Error durante la validación del token: {}", statusCode);
                        }
                    } else {
                        logger.error("Error inesperado durante la validación del token", e);
                    }
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                });
    }
}
