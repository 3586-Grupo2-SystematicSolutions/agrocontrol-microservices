package com.agrocontrol.msvc_gateway.beans;

import com.agrocontrol.msvc_gateway.filters.AuthFilter;
import lombok.AllArgsConstructor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@AllArgsConstructor
public class GatewayBeans {

    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public AuthFilter authFilter(WebClient.Builder webClientBuilder) {
        return new AuthFilter(webClientBuilder);
    }

    @Bean
    @Profile(value = "oauth2")
    public RouteLocator routeLocatorOauth2(RouteLocatorBuilder builder, AuthFilter authFilter) {
        return builder
                .routes()
                .route(route -> route
                        .path("/api/v1/roles/**")
                        .filters(filter -> filter.filter(authFilter))
                        .uri("lb://msvc-iam")
                )
                .route(route -> route
                        .path("/api/v1/users/**")
                        .filters(filter -> filter.filter(authFilter))
                        .uri("lb://msvc-iam")
                )
                .route(route -> route
                        .path("/api/v1/profiles/**")
                        .filters(filter -> filter.filter(authFilter))
                        .uri("lb://msvc-profile")
                )
                .route(route -> route
                        .path("/api/v1/fields/**")
                        .filters(filter -> filter.filter(authFilter))
                        .uri("lb://msvc-field")
                )
                .route(route -> route
                        .path("/api/v1/workers/**")
                        .filters(filter -> filter.filter(authFilter))
                        .uri("lb://msvc-field")
                )
                .route(route -> route
                        .path("/api/v1/finances/**")
                        .filters(filter -> filter.filter(authFilter))
                        .uri("lb://msvc-finance")
                )
                .route(route -> route
                        .path("/api/v1/payments/**")
                        .filters(filter -> filter.filter(authFilter))
                        .uri("lb://msvc-payment")
                )
                .route(route -> route
                        .path("/api/v1/products/**")
                        .filters(filter -> filter.filter(authFilter))
                        .uri("lb://msvc-store")
                )
                .route(route -> route
                        .path("/api/v1/payment-products/**")
                        .filters(filter -> filter.filter(authFilter))
                        .uri("lb://msvc-store")
                )
                .route(route -> route
                        .path("/api/v1/subscriptions/**")
                        .filters(filter -> filter.filter(authFilter))
                        .uri("lb://msvc-subscription")
                )
                .route(route -> route
                        .path("/api/v1/agricultural-processes/**")
                        .filters(filter -> filter.filter(authFilter))
                        .uri("lb://msvc-agriculturalProcess")
                )
                .route(route -> route
                        .path("/api/v1/authentication/**")
                        .uri("lb://msvc-iam")
                )
                .build();
    }
}