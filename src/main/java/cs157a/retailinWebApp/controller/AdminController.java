package cs157a.retailinWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/admin")
public class AdminController {
	@GetMapping("/admin")
	public String showAdminPage() {
		return "admin";
	}
}
