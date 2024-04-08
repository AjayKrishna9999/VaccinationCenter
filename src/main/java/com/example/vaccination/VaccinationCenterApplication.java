package com.example.vaccination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

//@EnableAsync
@SpringBootApplication
//@EnableEurekaClient
//@EnableFeignClients  //uncomment this if u want to use feign client.
//@EnableCaching
public class VaccinationCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccinationCenterApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

}
