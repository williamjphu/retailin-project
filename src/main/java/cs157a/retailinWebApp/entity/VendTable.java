package cs157a.retailinWebApp.entity;

public class VendTable {
	private int vendorID;
	private int itemID;
	private String date;
	private int quantity;
	private int vendorPrice;
	
	public VendTable() {
		// TODO Auto-generated constructor stub
	}

	public VendTable(int vendorID, int itemID) {
		this.vendorID = vendorID;
		this.itemID = itemID;
	}

	public int getVendorID() {
		return vendorID;
	}

	public void setVendorID(int vendorID) {
		this.vendorID = vendorID;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getVendorPrice() {
		return vendorPrice;
	}

	public void setVendorPrice(int vendorPrice) {
		this.vendorPrice = vendorPrice;
	}
}
