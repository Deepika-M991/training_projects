package com.example.SpringDataJPA;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories (basePackages ={"com.example.SpringDataJPA"})
public class JpaConfig {

    //connection to db
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("Qwerty@2024");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Company?createDatabaseIfNotExist=true&useSSL=false");

        return dataSource;
    }
//EntityManagerFactory: This is configured to use Hibernate as the JPA provider, automatically generate the database schema, and scan for entity classes in the specified package.

    //persist employee instances to MYSQL db
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        HibernateJpaVendorAdapter vendorAdapter=new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory =new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.example.SpringDataJPA");
        factory.setDataSource(dataSource());

        return factory;
    }
//Transaction Manager: This is set up to manage transactions for the entities managed by the EntityManagerFactory.
    //enable transactions against the employee entities
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager transactionManager =new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }
}

