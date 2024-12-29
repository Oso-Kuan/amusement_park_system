package com.easy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class EasyConfig implements WebMvcConfigurer {
	public static final String STATIC_PATH = "/img/";
	public static final String STATIC_DIR = "D:\\Eclipse\\Project_first\\img\\";

	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler(STATIC_PATH + "**").addResourceLocations("file:" + STATIC_DIR);
	}
}
