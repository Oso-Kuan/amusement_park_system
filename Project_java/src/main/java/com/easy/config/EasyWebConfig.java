package com.easy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.easy.interceptor.LoginInterceptor;

@Configuration
public class EasyWebConfig implements WebMvcConfigurer {
	public static final String IMAGE_PATH = "/img/";
	public static final String IMAGE_DIR = "D:\\Eclipse\\Project_first\\img\\";
	@Autowired
	LoginInterceptor loginInt;

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(IMAGE_PATH + "**").addResourceLocations("file:" + IMAGE_DIR);
	}

	// ≈‰÷√¿πΩÿ∆˜£¨»√¿πΩÿ∆˜…˙–ß
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//    	registry.addInterceptor(new LoginInterceptor());
		// /a/123ª·¿πΩÿ
//    	registry.addInterceptor(loginInt).addPathPatterns("/**").excludePathPatterns("/dologin","/logout");
	}
}
