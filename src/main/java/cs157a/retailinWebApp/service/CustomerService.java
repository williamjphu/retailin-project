package cs157a.retailinWebApp.service;

import java.util.List;

import cs157a.retailinWebApp.entity.Customer;

public interface CustomerService {
	public List<Customer> listCustomers();
	public void addCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(int customerId);
	public Customer findCustomerById(int customerId);
}
