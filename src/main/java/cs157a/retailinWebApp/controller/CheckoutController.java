package cs157a.retailinWebApp.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cs157a.retailinWebApp.entity.Customer;
import cs157a.retailinWebApp.entity.Item;
import cs157a.retailinWebApp.entity.Receipt;
import cs157a.retailinWebApp.entity.User;
import cs157a.retailinWebApp.service.CustomerService;
import cs157a.retailinWebApp.service.ItemService;
import cs157a.retailinWebApp.service.ReceiptService;
import cs157a.retailinWebApp.service.UserService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {
	@Autowired
	private ItemService itemService;
	@Autowired
	private ReceiptService receiptService;
	@Autowired
	private UserService userService;
	@Autowired
	private CustomerService customerService;

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
				boolean found = false;
				for(Item item: items) {
					if(item.getItemID() == id) {
						item.setQuantity(item.getQuantity() + quantity);
						found = true;
					}
				}
				if(!found) {
					items.add(new Item(it, quantity));
				}
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
	
	@GetMapping("/confirm")
	public String confirm(Model theModel) {
		Receipt receipt = new Receipt();
		theModel.addAttribute("receiptForm", receipt);
		List<User> employees = userService.getUsers();
		theModel.addAttribute("listEmployees", employees);
		List<Customer> customers = customerService.listCustomers();
		theModel.addAttribute("listCustomers", customers);
		theModel.addAttribute("total", getTotal());
		theModel.addAttribute("items", items);
		theModel.addAttribute("employeeID", Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName()));
		return "checkout-confirm";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("receiptForm") Receipt receipt) {
		receiptService.addReceipt(receipt, items);
		clear();
		return "redirect:/receipt/list";
	}

	public double getTotal() {
		total = 0;
		for(Item item : items) {
			total += item.getQuantity() * item.getPrice() * (100 - item.getDiscount())/100.0;
		}
		total = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
		return total;
	}
	
	public void clear() {
		items.clear();
	}
}