package com.mvcAnnotation;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@ComponentScan("com.mvcAnnotation")
//@PropertySource("classpath:application.properties") // 读取application.properties
@MapperScan("com.mvcAnnotation.mapper")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class AppConfig {
	// https://www.cnblogs.com/niechen/p/springmvc.html
	@Bean
	public DataSource dataSource(DruidConfig duridConfig) {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUsername(duridConfig.getUsername());
		dataSource.setPassword(duridConfig.getPassword());
		dataSource.setDriverClassName(duridConfig.getDriverClassName());
		dataSource.setUrl(duridConfig.getDbUrl());
		dataSource.setInitialSize(duridConfig.getInitialSize());
		System.out.println(duridConfig.getUsername());
		return dataSource;
	}
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource, DruidConfig duridConfig) {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage(duridConfig.getMapperLocations());
		return sqlSessionFactoryBean;
	}
	/**
	 * 事务
	 * @param dataSource
	 * @return
	 */
	  @Bean
	    public PlatformTransactionManager transactionManager(DataSource dataSource) {
	        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
	        return dataSourceTransactionManager;
	    }
}
