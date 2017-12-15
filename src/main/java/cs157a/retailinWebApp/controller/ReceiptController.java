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
import cs157a.retailinWebApp.entity.Receipt;
import cs157a.retailinWebApp.entity.User;
import cs157a.retailinWebApp.service.CustomerService;
import cs157a.retailinWebApp.service.ReceiptService;
import cs157a.retailinWebApp.service.UserService;

@Controller
@RequestMapping("/receipt")
public class ReceiptController {
	@Autowired
	private ReceiptService receiptService;
	@Autowired
	private UserService userService;
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listItems(Model theModel) {
		List<Receipt> receipts = receiptService.listReceipts();
		theModel.addAttribute("listReceipts", receipts);
		return "list-receipts";
	}
	
	@GetMapping("/add")
	public String add(Model theModel) {
		Receipt receipt = new Receipt();
		theModel.addAttribute("receiptForm", receipt);
		List<User> employees = userService.getUsers();
		theModel.addAttribute("listEmployees", employees);
		List<Customer> customers = customerService.listCustomers();
		theModel.addAttribute("listCustomers", customers);
		return "form-receipt";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("receiptId") Integer recId, Model theModel) {
		Receipt receipt = receiptService.getReceiptById(recId);
		theModel.addAttribute("receiptForm", receipt);
		List<User> employees = userService.getUsers();
		theModel.addAttribute("listEmployees", employees);
		List<Customer> customers = customerService.listCustomers();
		theModel.addAttribute("listCustomers", customers);
		return "form-receipt";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("receiptForm") Receipt receipt) {
		if (receipt.getTransactionNo() < 1) {
			receiptService.addReceipt(receipt);
		} else {
			receiptService.updateReceipt(receipt);
		}
		return "redirect:/receipt/list";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("receiptId") Integer receiptID) {
		receiptService.deleteReceipt(receiptID);
		return "redirect:/receipt/list";
	}
}
