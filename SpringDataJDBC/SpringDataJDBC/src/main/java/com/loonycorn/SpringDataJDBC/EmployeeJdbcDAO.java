package com.loonycorn.SpringDataJDBC;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeJdbcDAO implements EmployeeDAOInterface<EmployeeDetails> {
    private JdbcTemplate jdbcTemplate;

    RowMapper<EmployeeDetails> rowMap= (result,num)-> {
        EmployeeDetails employees=new EmployeeDetails();

       employees.setEmployeeId(result.getInt("employeeId"));
        employees.setDesignation(result.getString("designation"));
        employees.setFname(result.getString("fname"));
        employees.setLname(result.getString("lname"));

        return employees;

    };

    public EmployeeJdbcDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public List<EmployeeDetails> list(){
        String query="SELECT * from EmployeeDetails";

        return jdbcTemplate.query(query,rowMap);
    }
}
