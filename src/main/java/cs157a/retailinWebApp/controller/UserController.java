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
import cs157a.retailinWebApp.entity.User;
import cs157a.retailinWebApp.service.DepartmentService;
import cs157a.retailinWebApp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/list")
	public String listCustomers(@RequestParam(value = "keyword", defaultValue = "") String keyword, Model theModel) {
		List<User> users = new java.util.ArrayList<User>();
		if (keyword.length() > 0) {
			keyword = keyword.toLowerCase();
			for(User c : userService.getUsers()) {
				if (	c.getFirstName().toLowerCase().contains(keyword.toLowerCase()) ||
						c.getLastName().toLowerCase().contains(keyword) ||
						c.getEmail().toLowerCase().contains(keyword) ||
						(c.getAuthority() + "").toLowerCase().contains(keyword) ||
						(c.getPhoneNumber() + "").toLowerCase().contains(keyword)
						) {
					users.add(c);
				}
			}
		}
		else {
			users = userService.getUsers();
		}
		theModel.addAttribute("users", users);
		return "list-users";
	}
	
	@GetMapping("/add")
	public String add(Model theModel) {
		User user = new User();
		theModel.addAttribute("user", user);
		List<Department> depts = deptService.listDepartments();
		theModel.addAttribute("listDepartments", depts);
		return "form-user";
	}
	
	@GetMapping("/update")
	public String updateUser(@RequestParam("employeeID") Integer empID, Model theModel) {
		User theUser = userService.getUserById(empID);	
		theModel.addAttribute("user", theUser);
		List<Department> depts = deptService.listDepartments();
		theModel.addAttribute("listDepartments", depts);
		return "form-user";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("user") User theUser) {
		if (theUser.getEmpID() < 1) {
			userService.addUser(theUser);
		} else {
			userService.updateUser(theUser);
		}
		return "redirect:/user/list";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("employeeID") Integer empID) {
		userService.deleteUser(empID);
		return "redirect:/user/list";
	}
}