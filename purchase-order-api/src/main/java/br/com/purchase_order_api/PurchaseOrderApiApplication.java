package br.com.purchase_order_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PurchaseOrderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseOrderApiApplication.class, args);
	}

}
