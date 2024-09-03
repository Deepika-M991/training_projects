package com.example.SpringDataJPA;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRespository extends CrudRepository<Employee,Long> {

}
