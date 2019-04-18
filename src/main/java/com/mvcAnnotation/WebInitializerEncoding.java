package com.mvcAnnotation;

import javax.servlet.Filter;

import org.springframework.core.annotation.Order;
import org.springframework.util.StringUtils;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
@Order(2)
public class WebInitializerEncoding extends AbstractAnnotationConfigDispatcherServletInitializer
{
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {WebInitializer.class};  
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}
	@Override
	protected Filter[] getServletFilters() {
		System.out.println("encoding init");
		// TODO Auto-generated method stub
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return super.getServletFilters();
	}

}
