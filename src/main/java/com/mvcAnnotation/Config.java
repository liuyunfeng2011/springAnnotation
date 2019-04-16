package com.mvcAnnotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan("com.mvcAnnotation")
//@EnableWebMvc  这个类导入了DelegatingWebMvcConfiguration 而这个类extends WebMvcConfigurationSupport 屏蔽了我们自己集成的WebMvcConfigurationSupport
public class Config extends WebMvcConfigurationSupport{
	 private static final Logger logger = LoggerFactory.getLogger(Config.class); 
	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		logger.info("UrlBasedViewResolver");  
		UrlBasedViewResolver resolver=new UrlBasedViewResolver();
		resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		logger.info("addResourceHandlers");  
		registry.addResourceHandler("/html/**").addResourceLocations("/html/");
		super.addResourceHandlers(registry);
	}
	
	
}
