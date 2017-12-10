package cs157a.retailinWebApp.entity;

public class Department {
	private int deptID;
	private String name;
	private String description;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(int deptID) {
		this.deptID = deptID;
	}

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
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
