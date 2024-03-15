package me.hmservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HmServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmServiceApplication.class, args);
	}

}

