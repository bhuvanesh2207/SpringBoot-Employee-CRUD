package crud.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import crud.employee.entity.Employee;
import crud.employee.service.EmployeeService;

//@RestController: If a method returns a string, it will be treated as a plain string (i.e., the response body).
//To return a view name (like a JSP or HTML page), use @Controller instead. 
//@Controller does not treat the return value as just a string but can also resolve view names.

@Controller
public class EmployeeController {

    
	@Autowired 
	EmployeeService service;
	
	//create employee
	@PostMapping("/create")
	public void createNewEmployee(@ModelAttribute Employee emp) { // here instread of  @RequestBody we will use @ModelAttribute because we getting data from html
		service.createNewEmployee(emp);
	}
	
	@GetMapping("/createPage")
	public String createPage() {
		return "create";	// return cearte page
	}
	
	//update employee
	@PostMapping("/update")
	public void updateEmployee(@ModelAttribute Employee emp) { 
		service.updateEmployee(emp);
	}
	
	@GetMapping("/updatePage")
	public String updatePage() {
		return "update"; // return update page
	}
	
	//delete employee
	@PostMapping("/delete")
	public void deleteEmployee(@ModelAttribute Employee emp) { 
		service.deleteEmployee(emp);
	}
	
	@GetMapping("/deletePage")
	public String deletePage() {
		return "delete";	// return delete page
	}
	
	//search employee and displaying in the front end
	@GetMapping("/search")
	public String searchEmployee(Long id, Model model) {  // model will use if we want to send data from back to frontend 
		Employee e = service.searchEmployee(id);
		model.addAttribute("Emp",e); // this we add the employee obj to the model addAttribute("Emp",e) -> ("reference var", obj)
		System.out.println(e);
		return "searchResult";
	}
	
	@GetMapping("/searchPage")
	public String searchPage() {
		return "search";	// return delete page
	}
	
	@GetMapping("/viewAll")
	public String getAllEmployees(Model model) {
		List<Employee> empList = service.getAllEmployee();
		model.addAttribute("empList",empList);
		System.out.println(empList);
		return "viewAll";
	}
}
