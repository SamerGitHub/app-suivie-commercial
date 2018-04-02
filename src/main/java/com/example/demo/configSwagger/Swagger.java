package com.example.demo.configSwagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class Swagger {
  @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.web"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaInfo()) .securitySchemes(Collections.singletonList(apiKey()));
    }
    private ApiKey apiKey() {
        return new ApiKey("Authorization", "Bearer", "header");
    }


    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot Swagger Example API",
                "Spring Boot Swagger Example API for Youtube",
                "1.0",
                "Terms of Service",
                new Contact("Ecyl-it", "https://virtserver.swaggerhub.com/achrafpfe/projet/1.0.0",
                        "hsensamer88@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html"
        );

        return apiInfo;
    }

}
