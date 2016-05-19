package com.yocool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * springboot springfox(swagger2)示例:访问地址http://项目地址/swagger-ui.html
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.yocool")
public class Bootstrap {

	public static void main(String[] args) {
		SpringApplication.run(Bootstrap.class, args);
	}

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();

                .groupName("greetings")
				.apiInfo(apiInfo())
				.select()
				.paths(PathSelectors.regex("/greeting.*"))
				.build();
	}


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("springfox(swagger2) API文档自动生成示例")
				.description("这是使用spring-boot,springfox(swagger2)生成的API文档")
				.termsOfServiceUrl("http://www.example.com")
				.contact("作者:小强")
				.license("Apache2.0 开源协议")
				.licenseUrl("http://www.github.com/tzq668766")
				.version("1.0")
				.build();
	}
}
