package com.loonycorn.SpringDataJDBC;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class SpringDataJdbcApplication extends JpaRepositoriesAutoConfiguration {
	//DOUBT EMPDOA
	private static EmployeeDAOInterface<EmployeeDetails> empDAO;

	public SpringDataJdbcApplication(EmployeeDAOInterface<EmployeeDetails> empDAO) {
		this.empDAO = empDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJdbcApplication.class, args);
		System.out.println("\n**********************Employee List**************\n");

		//single row return  -error =value not found
		Optional<EmployeeDetails> employee=empDAO.getById(1);
		System.out.println(employee.get());

		//		ALL rows returned
//		List<EmployeeDetails> employees = empDAO.list();
//		for (EmployeeDetails row : employees) {
//			System.out.println("EmployeeID:" + row.getEmployeeId());
//			System.out.println("First name:" + row.getfname());
//			System.out.println("Last name:" + row.getLname());
//			System.out.println("Designation:" + row.getDesignation());
//			System.out.println();

		//ADD new
//		EmployeeDetails newEmp=new EmployeeDetails (null,"Roger","Smith","Automation");
//		empDAO.addNewEmployee(newEmp);


		 //update existing
//		EmployeeDetails empOne = empDAO.getById(1).orElse(new EmployeeDetails());
//		empOne.setDesignation("ITTTT");
//		empOne.setFname("jim");


//			List<EmployeeDetails> employees = empDAO.list();
//			for (EmployeeDetails row : employees) {
//				System.out.println("EmployeeID:" + row.getEmployeeId());
//				System.out.println("First name:" + row.getfname());
//				System.out.println("Last name:" + row.getLname());
//				System.out.println("Designation:" + row.getDesignation());
//				System.out.println();
//			}

	}
}
