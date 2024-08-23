package com.loonycorn.SpringDataJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

@SpringBootApplication
public class SpringDataJdbcApplication  {
 //DOUBT EMPDOA
	private static EmployeeDAOInterface<EmployeeDetails> empDAO;

	public SpringDataJdbcApplication(EmployeeDAOInterface<EmployeeDetails> empDAO) {
		this.empDAO = empDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJdbcApplication.class, args);
		System.out.println("\n**********************Employee List**************\n");

		List<EmployeeDetails> employees = empDAO.list();
		for (EmployeeDetails row : employees) {
			System.out.println("EmployeeID:" + row.getEmployeeId());
			System.out.println("First name:" + row.getfname());
			System.out.println("Last name:" + row.getLname());
			System.out.println("Designation:" + row.getDesignation());
			System.out.println();


		}

	}
}