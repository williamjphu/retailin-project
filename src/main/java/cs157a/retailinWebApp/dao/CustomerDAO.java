package cs157a.retailinWebApp.dao;

import java.util.List;

import cs157a.retailinWebApp.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer customer);
	
	//public Users getUser(String username);
	public Customer getCustomer(Integer phoneNo);
	
	//public void deleteUser(String username);
	public void deleteCustomer(Integer phoneNo);
}
