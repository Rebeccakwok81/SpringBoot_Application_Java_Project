package org.ac.cst8277.kwok_szeman.config;

import jakarta.persistence.EntityManagerFactory;
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

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "messageEntityManagerFactory",
        basePackages = "org.ac.cst8277.kwok_szeman.db2.repo",
        transactionManagerRef = "msgTransactionManager")
public class MessageConfig {

    //    message database config
    @Bean(name="msgDataSource")
    @ConfigurationProperties(prefix = "spring.db2.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/messagedatabase")
                .username("root")
                .password("new_password")
                .build();
    }

    @Bean(name="messageEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean messageEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("msgDataSource") DataSource dataSource){
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        return builder.dataSource(dataSource)
                .properties(properties)
                .packages("org.ac.cst8277.kwok_szeman.db2.entity")
                .persistenceUnit("Message")
                .build();
    }

    @Bean(name="msgTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("messageEntityManagerFactory") EntityManagerFactory messageEntityManagerFactory){
        return new JpaTransactionManager(messageEntityManagerFactory);
    }
}

