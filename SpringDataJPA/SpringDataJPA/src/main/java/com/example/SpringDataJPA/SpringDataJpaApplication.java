package com.example.SpringDataJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.SpringDataJPA")
@Import(JpaConfig.class)  //used to import beans

public class SpringDataJpaApplication {

	@Autowired
	private EmployeeRespository respository;

	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.register(SpringDataJpaApplication.class);
		ctx.refresh();

		SpringDataJpaApplication s=(SpringDataJpaApplication) ctx.getBean("mainBean");
		s.addEmployees();
		ctx.close();
	}

	private  void addEmployees(){
		Employee richard=new Employee("Richard",2);
		Employee shari=new Employee("Shari",4);
		Employee john=new Employee("john",2);
		Employee rose=new Employee("rose",1);

		respository.save(rose);
		respository.save(richard);
		respository.save(john);
		respository.save(shari);
	}

}
