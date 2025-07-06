package crud.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.employee.entity.Employee;
import crud.employee.repository.EmployeeRepository;

@Service // Indicates that this class is a service component in the Spring context.
public class EmployeeServiceImplementation implements EmployeeService {

    // Service classes should not directly interact with the database.
	// Instead, they use a repository, which handles communication with the DB.
	// Automatically injects the EmployeeRepository bean into this class.
	@Autowired 
    private EmployeeRepository repo;

    // Creates and saves a new employee record in the database.
    // If the table doesn't exist, Spring Data JPA will create it automatically.
    public void createNewEmployee(Employee emp) {
        repo.save(emp); // Persists the employee object to the database.
    }

    // Updates an existing employee record.
    // If the employee doesn't exist, it may create a new one depending on the ID.
    public void updateEmployee(Employee emp) {
        repo.save(emp); // save() works for both insert and update.
    }

    // Deletes an employee record from the database.
    public void deleteEmployee(Employee emp) {
        repo.delete(emp);
    }

    // Searches for an employee by their ID.
    // Returns the employee if found, or throws an exception if not.
    public Employee searchEmployee(Long id) {
        return repo.findById(id).get(); // Consider handling Optional properly in real applications.
    }

    // Retrieves all employee records from the database.
    @Override
    public List<Employee> getAllEmployee() {
        return repo.findAll();
    }
}
