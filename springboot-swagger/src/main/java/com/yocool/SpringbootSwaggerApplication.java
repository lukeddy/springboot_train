package com.yocool;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 * 访问API文档地址:http://localhost:8080/swagger.html
 * 说明:这里的访问地址是根据static/swagger.html所在位置,具体每个项目访问地址可能有所不同
 */
@SpringBootApplication
@EnableSwagger
public class SpringbootSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSwaggerApplication.class, args);
	}

	private SpringSwaggerConfig springSwaggerConfig;

	/**
	 * 自动装配swagger配置
	 */
	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}


	/**
	 * swagger参数配置
	 */
	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns(".*?");
	}


    /**
	 * api文档描述信息
	 * @return
	 */
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"测试使用的页面接口文档",
				"副标题",
				"爱上了法律上的飞机数量",
				"1231323@qq.com",
				"沙发沙发的沙发",
				"是否被第三方士大夫");
		return apiInfo;
	}
}
