package com.loonycorn.SpringDataJDBC;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAOInterface<Table> {

 List<Table> list();

 Optional<Table> getById(int employeeId);

 void addNewEmployee(Table table);

 void updateEmployee(Table table);

}
