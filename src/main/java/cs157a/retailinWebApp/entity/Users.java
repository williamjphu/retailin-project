package cs157a.retailinWebApp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="username")
	public int empID;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="first_name")
	private String firstName;	
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="enabled")
	private int enabled;
	
	@Column(name="authority") 
	private String authority;

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="department_id", referencedColumnName="department_id")
	private Department department;

//	@Column(name="department_id")
//	private String department;
//	@Column(name="department_id")
//	private int deptaID;
//	
//	public int getDeptaID() {
//		return deptaID;
//	}

//	public void setDeptaID(int deptID) {
//		this.deptaID = deptID;
//	}

	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(String lastName, String firstName, String password, String email, String phoneNumber, int enabled, String authority) {//, String authority) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.enabled = enabled;
		this.authority = authority;
	}
	
	public Users(String lastName, String firstName, String password, String email, String phoneNumber, int enabled, String authority, Department dept) {//, String authority) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.enabled = enabled;
		this.authority = authority;
		this.department = dept;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}	
	
	public int getDepartmentID() {
		return department.getDepartmentID();
	}
	
	@Override
	public String toString() {
		return "Users [username=" + empID + ", lastName=" + lastName + ", firstName=" + firstName + ", password="
				+ password + ", email=" + email + ", phoneNumber=" + phoneNumber + ", enabled=" + enabled + "]";
	}

}
