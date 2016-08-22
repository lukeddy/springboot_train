package com.yocool.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档配置
 * Author tangzq.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 访问地址http://项目地址/swagger-ui.html
     * @return
     */
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("collectors")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yocool.controller.api"))
                .paths(PathSelectors.any())
                //.paths(PathSelectors.regex("/api.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("强强API文档")
                .description("这是使用spring-boot,springfox(swagger2)生成的API文档")
                .termsOfServiceUrl("http://www.example.com")
                .contact(new Contact("小强","http://www.tzq.com","tzq@gmail.com"))
                .license("Apache2.0 开源协议")
                .licenseUrl("http://www.github.com/tzq668766")
                .version("1.0")
                .build();
    }
}
