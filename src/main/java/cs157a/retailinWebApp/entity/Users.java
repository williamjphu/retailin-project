package cs157a.retailinWebApp.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	public int empID;
	
	@Column(name="username")
	public String username;
	
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
	
	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(String username, String lastName, String firstName, String password, String email, String phoneNumber, int enabled) {//, String authority) {
		this.username = username;
		this.lastName = lastName;
		this.firstName = firstName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.enabled = enabled;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
//	@Enumerated(EnumType.STRING)
//	public Authorities getAuthority() {
//		return authority;
//	}
//	
//	@Enumerated(EnumType.STRING)
//	public Authority getAuthority() {
//		return role;
//	}
	
//	public enum Gender {
//		ROLE_ADMIN, ROLE_EMPLOYEE
//	}
	
//	public List<Authorities> getAuthorities() {
//		return authorities;
//	}
//
//	public void setAuthorities(List<Authorities> authorities) {
//		this.authorities = authorities;
//	}
//
//	public void add(Authorities tempAuth) {
//		if (authorities == null) {
//			authorities = new ArrayList<>();
//		}
//		authorities.add(tempAuth);
//		tempAuth.setUser(this);
//	}
	
//	private Set<Authorities> authorities;
//	
//	@OneToMany(mappedBy="authorities", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
//			CascadeType.DETACH, CascadeType.REFRESH})
//	public Set<Authorities> getAuthorities() {
//		return authorities;
//	}
//	
//	public void setAuthorities(Set<Authorities> authorities) {
//		this.authorities = authorities;
//	}
	
	@Override
	public String toString() {
		return "Users [username=" + username + ", lastName=" + lastName + ", firstName=" + firstName + ", password="
				+ password + ", email=" + email + ", phoneNumber=" + phoneNumber + ", enabled=" + enabled + "]";
	}
}
