package cs157a.retailinWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage(ModelMap map) {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String showHomePage(ModelMap map) {
		return "index";
	}
}