package cs157a.retailinWebApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {
	
	@Id
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private int price;
	
	@Column(name="discount")
	private int discount;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="category_id")
	private int categoryID;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(String itemName, String description, int price, int discount, int quantity, int categoryID) {
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.quantity = quantity;
		this.categoryID = categoryID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", description=" + description + ", price=" + price + ", discount="
				+ discount + ", quantity=" + quantity + ", categoryID=" + categoryID + "]";
	}
}
