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


import cs157a.retailinWebApp.entity.Payroll;
import cs157a.retailinWebApp.entity.User;
import cs157a.retailinWebApp.service.PayrollService;
import cs157a.retailinWebApp.service.UserService;

@Controller
@RequestMapping("/payroll")
public class PayrollController {
	
	@Autowired
	private PayrollService payrollService;

	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String listPayrolls(Model theModel) {
		List<Payroll> payrolls = payrollService.listPayrolls();
		theModel.addAttribute("listItems", payrolls);
		return "list-payrolls";
	}
	
	@GetMapping("/add")
	public String add(Model theModel) {
		Payroll payr = new Payroll();
		theModel.addAttribute("payrollForm", payr);
		List<User> employees = userService.getUsers();
		theModel.addAttribute("listEmployees", employees);
		return "form-payroll";
	}
	
	@GetMapping("/update")
	public String showUpdate(@RequestParam("payrollId") Integer payId, Model theModel) {
		Payroll payr = payrollService.getPayrollById(payId);
		theModel.addAttribute("payrollForm", payr);
		List<User> employees = userService.getUsers();
		theModel.addAttribute("listEmployees", employees);
		return "form-payroll";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("payrollForm") Payroll payroll) {
		if (payroll.getPayrollID() < 1) {
			payrollService.addPayroll(payroll);
		} else {
			payrollService.updatePayroll(payroll);
		}
		return "redirect:/payroll/list";
	}
	
	@GetMapping("/delete")
	public String deletePayroll(@RequestParam("payrollId") Integer payId) {
		payrollService.deletePayroll(payId);
		return "redirect:/payroll/list";
	}
}