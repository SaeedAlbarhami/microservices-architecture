package com.microservices.service.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

public class CustomerServiceApplication {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Customer").select()
                .apis(RequestHandlerSelectors.basePackage("com.microservices.service.customer"))
                .paths(any()).build().apiInfo(new ApiInfo("Customer Services",
                        "A set of services to provide data access to customers", "1.0.0", null,
                        new Contact("John Smith", "", null),null, null));
    }

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
}
