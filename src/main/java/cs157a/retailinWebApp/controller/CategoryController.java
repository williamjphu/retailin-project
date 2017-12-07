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

import cs157a.retailinWebApp.dao.CategoryDAO;
import cs157a.retailinWebApp.entity.Category;
import cs157a.retailinWebApp.entity.Customer;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAO;
	
	@GetMapping("/list")
	public String listCategories(Model theModel) {
		List<Category> categories = categoryDAO.getCategories();
		theModel.addAttribute("categories", categories);
		return "list-categories";
	}

	@GetMapping("/formAdd")
	public String showForm(Model theModel) {
		Category catego = new Category();
		theModel.addAttribute("theCategory", catego);
		return "category-form";
	}
	
	@PostMapping("/saveCategory")
	public String saveCustomer(@ModelAttribute("theCategory") Category category) {
		categoryDAO.saveCategory(category);
		return "redirect:/category/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("categoryID") int custID, Model theModel) {
		// get the customer from our service
		Category cat = categoryDAO.getCategory(custID);	
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("theCategory", cat);
		return "category-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("categoryID") int custID) {
		// delete the customer
		categoryDAO.deleteCategory(custID);
		return "redirect:/category/list";
	}
}