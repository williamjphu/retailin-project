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

import cs157a.retailinWebApp.entity.Vendor;
import cs157a.retailinWebApp.service.VendorService;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	private VendorService vendorService;
	
	@GetMapping("/list")
	public String listVendors(Model theModel) {
		List<Vendor> vendors = vendorService.listVendors();
		theModel.addAttribute("listVendors", vendors);
		return "list-vendors";
	}
	
	@GetMapping("/add")
	public String addVendor(Model theModel) {
		Vendor vendor = new Vendor();
		theModel.addAttribute("vendorForm", vendor);
		return "form-vendor";
	}
	
	@GetMapping("/update")
	public String updateVendor(@RequestParam("vendorId") Integer vendId, Model theModel) {
		Vendor vendor = vendorService.getVendorById(vendId);
		theModel.addAttribute("vendorForm", vendor);
		return "form-vendor";
	}
	
	@PostMapping("/save")
	public String saveVendor(@ModelAttribute("vendorForm") Vendor vendor) {
		if (vendor.getVendorID() < 1) {
			vendorService.addVendor(vendor);
		} else {
			vendorService.updateVendor(vendor);
		}
		return "redirect:/vendor/list";
	}
	
	@GetMapping("/delete")
	public String deleteVendor(@RequestParam("vendorId") Integer vendorID) {
		vendorService.deleteVendor(vendorID);
		return "redirect:/vendor/list";
	}
}
