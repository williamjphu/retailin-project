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

import cs157a.retailinWebApp.entity.Category;
import cs157a.retailinWebApp.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/list")
	public String listCategories(Model theModel) {
		List<Category> categories = categoryService.listCategories();
		theModel.addAttribute("categories", categories);
		return "list-categories";
	}

	@GetMapping("/add")
	public String showForm(Model theModel) {
		Category catego = new Category();
		theModel.addAttribute("categoryForm", catego);
		return "form-category";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("categoryForm") Category category) {
		if (category.getCategoryID() < 1) {
			categoryService.addCategory(category);
		} else {
			categoryService.updateCategory(category);
		}
		return "redirect:/category/list";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("categoryID") int catID, Model theModel) {
		Category cat = categoryService.getCategoryById(catID);
		theModel.addAttribute("categoryForm", cat);
		return "form-category";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("categoryID") int catID) {
		categoryService.deleteCategory(catID);
		return "redirect:/category/list";
	}
}