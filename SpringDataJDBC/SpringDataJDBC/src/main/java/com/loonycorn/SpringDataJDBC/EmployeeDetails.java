package com.loonycorn.SpringDataJDBC;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.sql.In;

@Table("EmployeeDetails")  //the table name should be same as of Database
public class EmployeeDetails {
    @Id
    @Column("employeeId")
    private Integer employeeId;
    @Column("fname")
    private String fname;
    @Column("lname")
    private String lname;
    @Column("designation")
    private String designation;
//default constructor
    public EmployeeDetails(){
    }
//parameterized constructor
    public EmployeeDetails(Integer employeeId,String fname,String lname,String designation){
        this.employeeId=employeeId;
        this.designation=designation;
        this.fname=fname;
        this.lname=lname;
    }
//invoke create method
    public static EmployeeDetails create(Integer employeeId,String fname,String lname,String designation){
        return new EmployeeDetails(employeeId,fname,lname,designation);
    }
//populate the table
    public  Integer getEmployeeId(){
        return employeeId;
    }
    public String getfname(){
        return fname;
    }
    public String getLname(){
        return lname;
    }
    public String getDesignation(){
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation=designation;
    }

    public void setFname(String fname) {
        this.fname=fname;
    }

    public void setLname(String lname) {
        this.lname=lname;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId= employeeId;
    }

    @Override
    public String toString(){
        return "EmployeeDetails{"+
                "employeeId="+employeeId +
                ",fname='"+fname +'\''+
                ",lname='"+lname + '\''+
                ",designation=" + designation +
                '}';
    }



}
