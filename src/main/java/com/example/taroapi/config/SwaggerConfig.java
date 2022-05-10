package com.example.taroapi.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * swagger配置
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return  new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.taroapi.controller"))
                .build();
    }

    private ApiInfo apiInfo(){
        return  new ApiInfoBuilder()
                .contact(new Contact("soarlm","",""))
                .title("hahhaha")
                .description("xxxxx")
                .version("1.1")
                .build();
    }
}
