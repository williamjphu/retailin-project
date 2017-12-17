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
import cs157a.retailinWebApp.entity.Item;
import cs157a.retailinWebApp.entity.Vendor;
import cs157a.retailinWebApp.service.CategoryService;
import cs157a.retailinWebApp.service.ItemService;
import cs157a.retailinWebApp.service.VendorService;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;
	@Autowired
	private CategoryService categoryServ;
	@Autowired
	private VendorService vendorServ;
	
	@GetMapping("/list")
	public String listItems(Model theModel) {
		List<Item> items = itemService.getItems();
		theModel.addAttribute("listItems", items);
		return "list-items";
	}
	
	@GetMapping("/add")
	public String add(Model theModel) {
		Item it = new Item();
		theModel.addAttribute("itemForm", it);
		List<Category> categories = categoryServ.listCategories();
		theModel.addAttribute("listCategories", categories);
		List<Vendor> vendors = vendorServ.listVendors();
		theModel.addAttribute("listVendors", vendors);
		return "form-item";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("itemId") Integer itemId, Model theModel) {
		Item it = itemService.findItemById(itemId);	
		theModel.addAttribute("itemForm", it);
		List<Category> categories = categoryServ.listCategories();
		theModel.addAttribute("listCategories", categories);
		List<Vendor> vendors = vendorServ.listVendors();
		theModel.addAttribute("listVendors", vendors);
		return "form-item";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("itemForm") Item item) {
		if (item.getItemID() < 1) {
			itemService.addItem(item);
		} else {
			itemService.updateItem(item);
		}
		return "redirect:/item/list";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("itemId") Integer itemId) {
		itemService.deleteItem(itemId);
		return "redirect:/item/list";
	}
}