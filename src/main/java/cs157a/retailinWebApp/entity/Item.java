package cs157a.retailinWebApp.entity;

public class Item {
	private int itemID;
	private String itemName;
	private String description;
	private double price;
	private int discount;
	private int quantity;
	private int categoryID;
	private int vendorID;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(int itemID) {
		this.itemID = itemID;
	}

	public Item(Item other, Integer quantity2) {
		this.itemID = other.itemID;
		this.itemName = other.itemName;
		this.description = other.description;
		this.price = other.price;
		this.discount = other.discount;
		this.quantity = quantity2;
		this.categoryID = other.categoryID;
		this.vendorID = other.vendorID;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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

	public int getVendorID() {
		return vendorID;
	}

	public void setVendorID(int vendorID) {
		this.vendorID = vendorID;
	}
}
