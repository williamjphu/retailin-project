package cs157a.retailinWebApp.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage(ModelMap map) {
		// logged user
		//principal.getName();
		return "login";
	}
	
//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public String showHomePage(ModelMap map, Principal principal) {
//		System.out.println(principal.getName());
//		return "index";
//	}
}