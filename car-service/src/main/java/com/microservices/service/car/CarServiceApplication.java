package com.microservices.service.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
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
public class CarServiceApplication {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Car").select()
                .apis(RequestHandlerSelectors.basePackage("com.microservices.service.car"))
                .paths(any()).build().apiInfo(new ApiInfo("Car Services",
                        "A set of services to provide data access to cars", "1.0.0", null,
                        new Contact("", "", null),null, null));
    }

	public static void main(String[] args) {
		SpringApplication.run(CarServiceApplication.class, args);
	}
}
