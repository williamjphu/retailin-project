package cs157a.retailinWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.users.UserService;

import cs157a.retailinWebApp.entity.Item;
import cs157a.retailinWebApp.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/list")
	public String listItems(Model theModel) {
		List<Item> items = itemService.getItems();
		theModel.addAttribute("listItems", items);
		return "list-items";
	}
	
//	@RequestMapping(value="/list", method=RequestMethod.GET)
//	public ModelAndView list() {
//		ModelAndView model = new ModelAndView("/list/list-items");
//		List<Item> items = itemService.getItems();
//		model.addObject("listItems", items);
//		return model;
//	}
	
	@GetMapping("/add")
	public String add(Model theModel) {
		// create model attribute to bind form data
		Item it = new Item();
		theModel.addAttribute("itemss", it);
		return "item-form";
	}
	
//	@RequestMapping(value="/add", method=RequestMethod.GET)
//	public ModelAndView add() {
//		ModelAndView model = new ModelAndView("item/item_form");
//		Item item = new Item();
//		model.addObject("item-form", item);
//		return model;
//	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("itemId") String itemName, Model theModel) {
		// get the customer from our service
		Item it = itemService.findItemById(itemName);	
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("itemss", it);
		// send over to our form	
		return "item-form";
	}
	
//	@RequestMapping(value="/update/{itemName}", method=RequestMethod.GET)
//	public ModelAndView update(@PathVariable("itemName") String itemName) {
//		ModelAndView model = new ModelAndView("item/item_form");
//		Item item = itemService.findItemById(itemName);
//		model.addObject("item-form", item);
//		return model;
//	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("itemss") Item item) {
		if (item.getItemName().length() < 1) {
			itemService.addItem(item);
		} else {
			itemService.updateItem(item);
//			itemService.addItem(item);
		}
		return "redirect:/item/list";
	}
	
//	@RequestMapping(value="/save", method=RequestMethod.POST)
//	public ModelAndView saveItem(@ModelAttribute("item-form") Item item) {
//		if (item != null & item.getItemName() != null) {
//			itemService.updateItem(item);
//		} else {
//			itemService.addItem(item);
//		}
//		return new ModelAndView("redirect:/item/list");
//	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("itemId") String itid) {
		// delete the customer
		itemService.deleteItem(itid);
		return "redirect:/item/list";
	}
	
//	@RequestMapping(value="/delete/{itemName}", method=RequestMethod.GET)
//	public ModelAndView delete(@PathVariable("itemName") String itemName) {
//		itemService.deleteItem(itemName);
//		return new ModelAndView("redirect:/item/list");
//	}
	
	
//	@Autowired
//	private ItemDAO itemDAO;
//
//	@GetMapping("/list")
//	public String listItems(Model theModel) {
//		// get customers from the service
//		List<Item> items = itemDAO.getItems();
//		// add the customers to the model
//		theModel.addAttribute("items", items);
//		return "list-items";
//	}
//	
//	@GetMapping("/showFormForAdd")
//	public String showFormForAdd(Model theModel) {
//		// create model attribute to bind form data
//		Item it = new Item();
//		theModel.addAttribute("itemss", it);
//		return "item-form";
//	}
//	
//	@PostMapping("/saveItem")
//	public String saveItem(@ModelAttribute("itemss") Item it) {
//		// save the customer using our service
////		itemDAO.saveItem(it);	
//		return "redirect:/item/list";
//	}
//	
//	@GetMapping("/showFormForUpdate")
//	public String showFormForUpdate(@RequestParam("itemId") String itid, Model theModel) {
//		// get the customer from our service
//		Item it = itemDAO.getItem(itid);	
//		// set customer as a model attribute to pre-populate the form
//		theModel.addAttribute("itemss", it);
//		// send over to our form		
//		return "item-form";
//	}
//	
//	@GetMapping("/delete")
//	public String deleteCustomer(@RequestParam("itemId") String itid) {
//		// delete the customer
//		itemDAO.deleteItem(itid);
//		return "redirect:/item/list";
//	}
}