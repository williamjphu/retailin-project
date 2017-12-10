package cs157a.retailinWebApp.entity;

public class Category {
	private int categoryID;
	private String name;
	private String description;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(int categoryID) {
		this.categoryID = categoryID;
	}
	
	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
