package br.com.sale_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SaleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaleApiApplication.class, args);
	}

}
