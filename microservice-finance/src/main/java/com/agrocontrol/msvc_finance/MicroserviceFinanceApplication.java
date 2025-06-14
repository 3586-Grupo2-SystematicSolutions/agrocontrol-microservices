package com.agrocontrol.msvc_finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Locale;

@EnableJpaAuditing
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceFinanceApplication {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		SpringApplication.run(MicroserviceFinanceApplication.class, args);
	}

}
