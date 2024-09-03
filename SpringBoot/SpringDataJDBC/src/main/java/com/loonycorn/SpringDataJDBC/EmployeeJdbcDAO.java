package com.loonycorn.SpringDataJDBC;

import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryDependsOnPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.dao.DataAccessException;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<EmployeeDetails> getById(int id) {

        String query="Select * from EmployeeDetails where employeeId=?";
        EmployeeDetails employee=null;

        try{
            employee=jdbcTemplate.queryForObject(query,rowMap,id);
        }
        catch (DataAccessException dataAccessException){
            System.out.println(dataAccessException);
        }
        return Optional.empty();
    }

    @Override
    public void addNewEmployee(EmployeeDetails employeeDetails){
        String insertQuery="INSERT INTO EmployeeDetails(fname,lname,designation)"+
                "VALUES(?,?,?)";
        jdbcTemplate.update(insertQuery,
                employeeDetails.getfname(),
                employeeDetails.getDesignation(),
                employeeDetails.getLname());
    }

    @Override
    public void updateEmployee(EmployeeDetails employeeDetails){

        String updateQuery="UPDATE EmployeeDetails SET fname=?,"+
                "lname=?,designation=? WHERE employeeId=?";
        jdbcTemplate.update(updateQuery,
                employeeDetails.getEmployeeId(),
                employeeDetails.getDesignation(),
                employeeDetails.getLname(),
                employeeDetails.getfname());

    }
}
