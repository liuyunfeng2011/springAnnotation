package com.mvcAnnotation;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 替代web.xml文件
 * 
 * @author snake
 *
 */
public class WebInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		// Spring mvc的配置文件
		ctx.register(Config.class);
		// ctx.setConfigLocation("classpath*:/spring-mvc.xml"); 调用本地xml配置文件相当于
//		<context-param>
//		<param-name>contextConfigLocation</param-name>
//		<param-value>classpath*:/applicationContext.xml
//		</param-value>
//	</context-param>
		ctx.setServletContext(servletContext);
		Dynamic servlet = servletContext.addServlet("myjob", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}
