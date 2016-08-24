package com.yocool.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

/**
 * Sitemesh模板实现
 */
@Configuration
public class SitemeshConfig {
	@Bean
	public Filter sitemeshFilter(){
		return new SiteMeshFilter();
	}
}
