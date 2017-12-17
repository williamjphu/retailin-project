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

import cs157a.retailinWebApp.entity.Customer;
import cs157a.retailinWebApp.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(@RequestParam(value = "keyword", defaultValue = "") String keyword, Model theModel) {
		List<Customer> customersFiltered = new java.util.ArrayList<Customer>();
		if (keyword.length() > 0) {
			keyword = keyword.toLowerCase();
			for(Customer c : customerService.listCustomers()) {
				if (	c.getFirstName().toLowerCase().contains(keyword.toLowerCase()) ||
						c.getLastName().toLowerCase().contains(keyword) ||
						c.getEmail().toLowerCase().contains(keyword) ||
						(c.getZipCode() + "").toLowerCase().contains(keyword) ||
						(c.getPhoneNumber() + "").toLowerCase().contains(keyword)
						) {
					customersFiltered.add(c);
				}
			}
		}
		else {
			customersFiltered = customerService.listCustomers();
		}
		theModel.addAttribute("customers", customersFiltered);
		return "list-customers";
	}

	@GetMapping("/add")
	public String addCustomer(Model theModel) {
		Customer cust = new Customer();
		theModel.addAttribute("customerForm", cust);
		return "form-customer";
	}
	
	@GetMapping("/update")
	public String updateCustomer(@RequestParam("custID") int custID, Model theModel) {
		Customer cust = customerService.findCustomerById(custID);
		theModel.addAttribute("customerForm", cust);
		return "form-customer";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("customerForm") Customer customer) {
		if (customer.getCustomerID() < 1) {
			customerService.addCustomer(customer);
		} else {
			customerService.updateCustomer(customer);
		}
		return "redirect:/customer/list";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("custID") int custID) {
		customerService.deleteCustomer(custID);
		return "redirect:/customer/list";
	}
}