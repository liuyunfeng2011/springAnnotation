package com.mvcAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan("com.mvcAnnotation")
@EnableWebMvc
public class Config {
	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver=new UrlBasedViewResolver();
		resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
}
