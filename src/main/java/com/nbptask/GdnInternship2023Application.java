package com.nbptask;

import com.nbptask.service.MyService;
import com.nbptask.service.MyServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GdnInternship2023Application {

	@Value("${api.base-url}")
	private String baseUrl;

	public static void main(String[] args) {
		SpringApplication.run(GdnInternship2023Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public MyService myService() {
		return new MyServiceImpl(restTemplate(), baseUrl);
	}

}
