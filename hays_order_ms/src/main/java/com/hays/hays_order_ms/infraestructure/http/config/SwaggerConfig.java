package com.hays.hays_order_ms.infraestructure.http.config;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors.basePackage("com.hays.hays_order_ms")
                )
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "API REST - HAYS Tech Test",
                "REST API",
                "1.0",
                "http://codmind.com/terms",
                new Contact("Felipe Esteban Riaño Pineda", "https://www.linkedin.com/in/felipe-r-pineda/", "felipepineda1997@gmail.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }

}


