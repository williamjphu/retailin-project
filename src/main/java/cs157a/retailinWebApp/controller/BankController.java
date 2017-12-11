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

import cs157a.retailinWebApp.entity.BankAccount;
import cs157a.retailinWebApp.entity.User;
import cs157a.retailinWebApp.service.BankService;
import cs157a.retailinWebApp.service.UserService;

@Controller
@RequestMapping("/bank-account")
public class BankController {
	@Autowired
	private BankService bankService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String listAccounts(Model theModel) {
		List<BankAccount> accts = bankService.listBankAccounts();
		theModel.addAttribute("listAccounts", accts);
		return "list-bank-accounts";
	}
	
	@GetMapping("/add")
	public String add(Model theModel) {
		BankAccount acct = new BankAccount();
		theModel.addAttribute("bankForm", acct);
		List<User> employees = userService.getUsers();
		theModel.addAttribute("listEmployees", employees);
		return "form-bank-accounts";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("bankID") Integer bankId, Model theModel) {
		BankAccount acct = bankService.getBankAccountById(bankId);
		theModel.addAttribute("bankForm", acct);
		List<User> employees = userService.getUsers();
		theModel.addAttribute("listEmployees", employees);
		return "form-bank-accounts";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("bankForm") BankAccount acct) {
		if (acct.getAcctID() < 1) {
			bankService.addBankAccount(acct);
		} else {
			bankService.updateBankAccount(acct);
		}
		return "redirect:/bank-account/list";
	}
	
	@GetMapping("/delete")
	public String deleteAccount(@RequestParam("bankID") Integer bankId) {
		bankService.deleteBankAccount(bankId);
		return "redirect:/bank-account/list";
	}
}