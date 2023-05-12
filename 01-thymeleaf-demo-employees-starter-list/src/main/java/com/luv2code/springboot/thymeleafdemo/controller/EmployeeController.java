package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService theEmployeeService){
		employeeService=theEmployeeService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		// get employees from the data base
		List<Employee> theEmployees =employeeService.findAll();
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";  //nombre del archivo list-employees.html
	}
	@GetMapping("/showFormForAdd") //esta propiedad viene del boton "Add Employee" list-employees.html
	public String showFormForAdd(Model theModel){
		// create model attribute to bind form data
		Employee theEmployee=new Employee();

		theModel.addAttribute("employee", theEmployee);

		return "employees/employee-form";  //nombre del archivo employee-form.html
	}
	@GetMapping("/showFormForUpdate") //esta propiedad viene del boton "Update" list-employees.html
	public String showFormForAdd(@RequestParam("employeeId")int theId, Model theModel ){
		//Get employees from the service
		Employee theEmployee=employeeService.findById(theId);

		//set employee in the model to populate the form
		theModel.addAttribute("employee", theEmployee);

		// send over to our form
		return "employees/employee-form"; //nombre del archivo employee-form.html
	}

	@GetMapping("/showFormForDelete") //esta propiedad viene del boton "Delete" list-employees.html
	public String showFormForDelete(@RequestParam("employeeId")int theId ){

		//Delete the employee 
		employeeService.deleteById(theId);

		// send over to our form
		return "redirect:/employees/list"; //nombre del archivo employee-form.html
	}


	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
		//save the employees
		employeeService.save(theEmployee);

		// use re direct to prevent duplicate submissions
		return "redirect:/employees/list";
	}

}

