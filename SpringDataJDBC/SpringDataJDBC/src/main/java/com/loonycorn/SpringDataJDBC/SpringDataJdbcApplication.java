package com.loonycorn.SpringDataJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

@SpringBootApplication
public class SpringDataJdbcApplication implements CommandLineRunner {

//this autowired takes complete care of the drivers , managers and connectors related to JDBC
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
				SpringApplication.run(SpringDataJdbcApplication.class, args);
	}

	//overriding the run method declared in commandline interface
	@Override
	public void run(String... args) throws Exception {

		//1.CREATE
		String query="create table if not exists EmployeeDetails(\n" +
				"\t\t\t\t  employeeId int primary key,\n" +
				"\t\t\t\t  fname  varchar(100),\n" +
				"\t\t\t\t  lname  varchar(100),\n" +
				"\t\t\t\t  designation varchar(100)); ";
		jdbcTemplate.execute(query);
          //2.INSERT
		String query="INSERT INTO EmployeeDetails VALUES(?,?,?,?);";
		jdbcTemplate.update(query,100,"james","powell","IT");
		jdbcTemplate.update(query,101,"abby","cruz","finance");
		jdbcTemplate.update(query,102,"jonny","paul","accounts");
		//3.UPDATE
		String query= " UPDATE EmployeeDetails SET designation= ? WHERE employeeID=?";
			jdbcTemplate.update(query,"senior IT",102);

		//4.READ
		String query="SELECT * FROM EmployeeDetails";

		System.out.println("\n********************\n");
		System.out.println("List of Employees: ");

		List emplist=jdbcTemplate.queryForList(query);
		for(Object emp:emplist){
			System.out.println(emp.toString());
		}
		System.out.println("\n********************\n");

		//5.DELETE
		String query="DELETE from EmployeeDetails WHERE employeeID=? ";
		jdbcTemplate.update(query,100);

		System.out.format("Delete performed");
		query="SELECT * FROM EmployeeDetails";

		System.out.println("\n************************\n");
		System.out.println("list of employees:");

		List emplist=jdbcTemplate.queryForList(query);
		for(Object emp:emplist){
			System.out.println(emp.toString());
		}
		System.out.println("\n********************\n");
	}
}
