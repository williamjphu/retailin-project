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

import cs157a.retailinWebApp.entity.Users;
import cs157a.retailinWebApp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		// get customers from the service
		List<Users> users = userService.getUsers();
		// add the customers to the model
		theModel.addAttribute("users", users);
		return "list-users";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		Users user = new Users();
		theModel.addAttribute("user", user);
		return "user-form";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") Users theUser) {
		// save the customer using our service
		userService.saveUser(theUser);	
		return "redirect:/user/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeID") Integer empID, Model theModel) {
		// get the customer from our service
		Users theUser = userService.getUser(empID);	
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("user", theUser);
		// send over to our form		
		return "user-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("employeeID") Integer empID) {
		// delete the customer
		userService.deleteUser(empID);
		return "redirect:/user/list";
	}
}