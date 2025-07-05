// repository which will intract with db 

package crud.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import crud.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{ //JpaRepository<Employee, Long> <classname, primarykey dataType>
	
}
