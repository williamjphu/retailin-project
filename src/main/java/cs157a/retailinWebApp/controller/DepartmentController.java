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

import cs157a.retailinWebApp.entity.Department;
import cs157a.retailinWebApp.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		List<Department> departments = deptService.listDepartments();
		theModel.addAttribute("departments", departments);
		return "list-departments";
	}
	
	@GetMapping("/add")
	public String add(Model theModel) {
		// create model attribute to bind form data
		Department dept = new Department();
		theModel.addAttribute("deptForm", dept);
		return "form-department";
	}
	
	@GetMapping("/update")
	public String updateDepartment(@RequestParam("deptId") Integer deptID, Model theModel) {
		Department dept = deptService.getDepartmentById(deptID);	
		theModel.addAttribute("deptForm", dept);
		return "form-department";
	}
	
	@PostMapping("/save")
	public String saveDepartment(@ModelAttribute("deptForm") Department dept) {
		if (dept.getDeptID() < 1) {
			deptService.addDepartment(dept);
		} else {
			deptService.updateDepartment(dept);
		}
		return "redirect:/department/list";
	}

	@GetMapping("/delete")
	public String deleteDepartment(@RequestParam("deptId") Integer deptID) {
		deptService.deleteDepartment(deptID);
		return "redirect:/department/list";
	}
}