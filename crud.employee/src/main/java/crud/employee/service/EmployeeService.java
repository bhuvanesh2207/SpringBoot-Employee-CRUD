package crud.employee.service;

import java.util.List;

import crud.employee.entity.Employee;

public interface EmployeeService {
	void createNewEmployee(Employee emp); // here we crt a method to do create option
	
	void updateEmployee(Employee emp); //update employee
	
	void deleteEmployee(Employee emp); //delete employee
	
	Employee searchEmployee(Long id); //search employee

	List<Employee> getAllEmployee();
	
}
