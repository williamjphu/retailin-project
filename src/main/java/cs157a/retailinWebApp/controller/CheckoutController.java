package cs157a.retailinWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cs157a.retailinWebApp.entity.Item;
import cs157a.retailinWebApp.service.ItemService;
import cs157a.retailinWebApp.service.ReceiptService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {
	@Autowired
	private ItemService itemService;
	@Autowired
	private ReceiptService receiptService;
	
	private List<Item> items;
	private double total;
	
	@GetMapping("")
	public String list(@RequestParam(value = "item", defaultValue = "0") Integer id, 
			@RequestParam(value = "amount", defaultValue = "0") Integer quantity, Model theModel) {
		if(items == null) {
			items = new java.util.ArrayList<Item>();
		}
		//if item is not found, ie someone tries URL or init state
		try {
			Item it = itemService.findItemById(id);
			if(id > 0) {
				items.add(new Item(it, quantity));
			}
		}
		catch(Exception e) {}
		theModel.addAttribute("cartItems", items);
		theModel.addAttribute("allItems", itemService.getItems());
		theModel.addAttribute("total", getTotal());
		return "checkout";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("index") Integer index) {
		items.remove(index.intValue());
		return "redirect:/checkout";
	}
	
	public double getTotal() {
		total = 0;
		for(Item item : items) {
			total += item.getQuantity() * item.getPrice() * (100 - item.getDiscount())/100.0;
		}
		return total;
	}
}