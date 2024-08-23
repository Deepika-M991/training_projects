package com.loonycorn.SpringDataJDBC;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

public interface EmployeeDAOInterface<Table> {

 List<Table> list();

}
