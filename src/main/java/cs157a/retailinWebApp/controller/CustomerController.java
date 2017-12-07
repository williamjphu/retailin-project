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

import cs157a.retailinWebApp.dao.CustomerDAO;
import cs157a.retailinWebApp.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerDAO customerDAO;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> customers = customerDAO.getCustomers();
		theModel.addAttribute("customers", customers);
		return "list-customers";
	}

	@GetMapping("/formAdd")
	public String showForm(Model theModel) {
		Customer cust = new Customer();
		theModel.addAttribute("customer", cust);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerDAO.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("custID") int custID, Model theModel) {
		// get the customer from our service
		Customer cust = customerDAO.getCustomer(custID);	
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", cust);
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("custID") int custID) {
		// delete the customer
		customerDAO.deleteCustomer(custID);
		return "redirect:/customer/list";
	}
}