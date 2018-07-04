package com.microservices.service.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient


public class BookingServicesApplication {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Bookings").select()
                .apis(RequestHandlerSelectors.basePackage("com.microservices.services.reservation"))
                .paths(any()).build().apiInfo(new ApiInfo("Booking Services",
                        "A set of services to provide data access to bookings", "1.0.0", null,
                        new Contact("", "", null),null, null));
    }

	public static void main(String[] args) {
		SpringApplication.run(BookingServicesApplication.class, args);
	}
}
