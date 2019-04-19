package com.mvcAnnotation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:druid.properties")
public class DruidConfig {
	  private Logger logger = Logger.getLogger(DruidConfig.class);

	    @Value("${spring.datasource.url}")  
	    private String dbUrl;  

	    @Value("${spring.datasource.username}")  
	    private String username;  

	    @Value("${spring.datasource.password}")  
	    private String password;  

	    @Value("${spring.datasource.driverClassName}")  
	    private String driverClassName;  

	    @Value("${spring.datasource.initialSize}")  
	    private Integer initialSize;  

	    @Value("${spring.datasource.minIdle}")  
	    private Integer minIdle;  

	    @Value("${spring.datasource.maxActive}")  
	    private Integer maxActive;  

	    @Value("${spring.datasource.maxWait}")  
	    private Integer maxWait;  

	    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")  
	    private Integer timeBetweenEvictionRunsMillis;  

	    @Value("${spring.datasource.minEvictableIdleTimeMillis}")  
	    private Integer minEvictableIdleTimeMillis;  

	    @Value("${spring.datasource.validationQuery}")  
	    private String validationQuery;  

	    @Value("${spring.datasource.testWhileIdle}")  
	    private boolean testWhileIdle;  

	    @Value("${spring.datasource.testOnBorrow}")  
	    private boolean testOnBorrow;  

	    @Value("${spring.datasource.testOnReturn}")  
	    private boolean testOnReturn;  

	    @Value("${spring.datasource.poolPreparedStatements}")  
	    private boolean poolPreparedStatements;  

	    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")  
	    private Integer maxPoolPreparedStatementPerConnectionSize;  

	    @Value("${spring.datasource.filters}")  
	    private String filters;  

	    @Value("{spring.datasource.connectionProperties}")  
	    private String connectionProperties;

	    @Value("{mybatis.type.alias.package}")  
	    private String mapperLocations;
	    
	    
		public String getMapperLocations() {
			return mapperLocations;
		}

		public Logger getLogger() {
			return logger;
		}

		public void setDbUrl(String dbUrl) {
			this.dbUrl = dbUrl;
		}

		public String getDbUrl() {
			return dbUrl;
		}

		public String getUsername() {
			return username;
		}

		public String getPassword() {
			return password;
		}

		public String getDriverClassName() {
			return driverClassName;
		}

		public int getInitialSize() {
			return initialSize;
		}

		public int getMinIdle() {
			return minIdle;
		}

		public int getMaxActive() {
			return maxActive;
		}

		public int getMaxWait() {
			return maxWait;
		}

		public int getTimeBetweenEvictionRunsMillis() {
			return timeBetweenEvictionRunsMillis;
		}

		public int getMinEvictableIdleTimeMillis() {
			return minEvictableIdleTimeMillis;
		}

		public String getValidationQuery() {
			return validationQuery;
		}

		public boolean isTestWhileIdle() {
			return testWhileIdle;
		}

		public boolean isTestOnBorrow() {
			return testOnBorrow;
		}

		public boolean isTestOnReturn() {
			return testOnReturn;
		}

		public boolean isPoolPreparedStatements() {
			return poolPreparedStatements;
		}

		public int getMaxPoolPreparedStatementPerConnectionSize() {
			return maxPoolPreparedStatementPerConnectionSize;
		}

		public String getFilters() {
			return filters;
		}

		public String getConnectionProperties() {
			return connectionProperties;
		}  
		 @Bean
		    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		        return new PropertySourcesPlaceholderConfigurer();
		    }
	    
}
