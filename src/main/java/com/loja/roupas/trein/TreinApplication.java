package com.loja.roupas.trein;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@EntityScan(basePackages = "com.loja.roupas.trein.domain.entities")
@EnableJpaRepositories(basePackages = "com.loja.roupas.trein.repositories")
@SpringBootApplication(scanBasePackages = "com.loja.roupas.trein")
public class TreinApplication {

	public static void main(String[] args) {

		log.info("Iniciando a API WenShop!!!");
		SpringApplication.run(TreinApplication.class, args);
	}
}
