package cs157a.retailinWebApp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="department_id")
	private int departmentID;
	
	@Column(name="department_name")
	private String name;
	
	@Column(name="additional")
	private String additional;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="department", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Users> users;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(int departmentID, String name, String additional) {
		this.departmentID = departmentID;
		this.name = name;
		this.additional = additional;
	}


	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}
	
	// convenience methods for bi-directional relationship
	public void add(Users tempUser) {
		if (users == null) {
			users = new ArrayList<>();
		}
		users.add(tempUser);
		tempUser.setDepartment(this);
	}
}
