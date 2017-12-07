package cs157a.retailinWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cs157a.retailinWebApp.dao.DepartmentDAO;
import cs157a.retailinWebApp.entity.Department;
import cs157a.retailinWebApp.entity.Users;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentDAO departmentDAO;	
	
	@GetMapping("/list")
	public String listDepartments(Model theModel) {
		// get customers from the service
		List<Department> departments = departmentDAO.getDepartments();
		// add the customers to the model
		theModel.addAttribute("departments", departments);
		return "list-departments";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		Department dept = new Department();
		theModel.addAttribute("depart", dept);
		return "form-department";
	}
	
	@PostMapping("/saveDepartment")
	public String saveDepartment(@ModelAttribute("depart") Department dept) { 
		departmentDAO.saveDepartment(dept);
		return "redirect:/department/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("deptID") Integer departmentID, Model theModel) {
		// get the customer from our service
		Department dept = departmentDAO.getDepartment(departmentID);	
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("depart", dept);	
		return "form-department";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("deptID") Integer deptID) {
		// delete the customer
		departmentDAO.deleteDepartment(deptID);
		return "redirect:/department/list";
	}
}
