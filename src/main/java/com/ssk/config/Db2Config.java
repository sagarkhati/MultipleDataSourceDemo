package com.ssk.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.ssk.db2.repos", entityManagerFactoryRef = "secondEntityManagerFactory", transactionManagerRef = "secondTransactionManager")
public class Db2Config {

	@Bean(name = "secondDataSource")
	@ConfigurationProperties(prefix = "spring.second-datasource")
	public DataSource secondDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "secondEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("secondDataSource") DataSource dataSource) {
		HashMap<String, Object> propertiesHashMap = new HashMap<String, Object>();
		propertiesHashMap.put("hibernate.hbm2ddl.auto", "update");

		return builder.dataSource(dataSource).properties(propertiesHashMap).packages("com.ssk.db2.entities")
				.persistenceUnit("db2").build();
	}

	@Bean(name = "secondTransactionManager")
	public PlatformTransactionManager secondTransactionManager(
			@Qualifier("secondEntityManagerFactory") EntityManagerFactory secondEntityManagerFactory) {
		return new JpaTransactionManager(secondEntityManagerFactory);
	}
}
