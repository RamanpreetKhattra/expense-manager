package com.ionwallet.expensemanager.conf;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@PropertySource(value = { "classpath:/db.properties"})
public class JPAConfiguration  {
	
	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setURL(env.getProperty("spring.datasource.url"));
		dataSource.setUser(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException{
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] {
				"com.ionwallet.expensemanager.entities"
		});
		em.setJpaProperties(additionalProperties());
		return em;
	}
	
	Properties additionalProperties() {
	      Properties properties = new Properties();
	      properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
	      properties.setProperty("hibernate.dialect", env.getProperty("spring.jpa.database-platform"));
	      return properties;
	   }
	
	
}
