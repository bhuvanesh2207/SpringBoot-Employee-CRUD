package crud.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.employee.entity.Employee;
import crud.employee.repository.EmployeeRepository;

@Service // -> tell spring it a service not a class.
public class EmployeeServiceImplementation implements EmployeeService {

	// service need to intract with db but service cant but repo can so we using
	// repo.
	// the repository is used to communicate with db so we creat a reference of the
	// repo.
	@Autowired // will connect the serive and repo
	EmployeeRepository repo;

	public void createNewEmployee(Employee emp) {
		repo.save(emp); // this single line of code will get the obj and repo will send the data to db
						// and the table will be crt and data will be added to the table.
	}

	public void updateEmployee(Employee emp) {
		repo.save(emp);
	}

	public void deleteEmployee(Employee emp) {
		repo.delete(emp);
	}

	public Employee searchEmployee(Long id) {
		return repo.findById(id).get();

	}

	@Override
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

}
