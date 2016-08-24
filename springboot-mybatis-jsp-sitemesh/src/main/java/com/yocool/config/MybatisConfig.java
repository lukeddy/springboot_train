package com.yocool.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringUtils;

/**
 * 修正MybtisAutoConfig的bug
 * (配置config属性后其他属性会被忽略)
 */
@Configuration
@EnableConfigurationProperties(MybatisProperties.class)
public class MybatisConfig {
	@Autowired
	private MybatisProperties properties;

	@Autowired
	private ResourceLoader resourceLoader = new DefaultResourceLoader();

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dataSource);
		if (StringUtils.hasText(this.properties.getConfig())) {
			factory.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfig()));
		}
		factory.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
		factory.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
		factory.setMapperLocations(this.properties.getMapperLocations());
		return factory.getObject();
	}
}
