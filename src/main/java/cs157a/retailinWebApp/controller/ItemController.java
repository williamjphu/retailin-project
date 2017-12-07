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

import cs157a.retailinWebApp.dao.ItemDAO;
import cs157a.retailinWebApp.entity.Item;
import cs157a.retailinWebApp.entity.Users;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemDAO itemDAO;

	@GetMapping("/list")
	public String listItems(Model theModel) {
		// get customers from the service
		List<Item> items = itemDAO.getItems();
		// add the customers to the model
		theModel.addAttribute("items", items);
		return "list-items";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		Item it = new Item();
		theModel.addAttribute("itemss", it);
		return "item-form";
	}
	
	@PostMapping("/saveItem")
	public String saveItem(@ModelAttribute("itemss") Item it) {
		// save the customer using our service
		itemDAO.saveItem(it);	
		return "redirect:/item/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("itemId") String itid, Model theModel) {
		// get the customer from our service
		Item it = itemDAO.getItem(itid);	
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("itemss", it);
		// send over to our form		
		return "item-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("itemId") String itid) {
		// delete the customer
		itemDAO.deleteItem(itid);
		return "redirect:/item/list";
	}
}