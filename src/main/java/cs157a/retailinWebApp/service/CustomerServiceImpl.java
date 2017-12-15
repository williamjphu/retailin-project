package cs157a.retailinWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs157a.retailinWebApp.dao.CustomerDAO;
import cs157a.retailinWebApp.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO custDao;
	
	@Override
	public List<Customer> listCustomers() {
		return custDao.listCustomers();
	}

	@Override
	public void addCustomer(Customer customer) {
		custDao.addCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		custDao.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(int customerId) {
		custDao.deleteCustomer(customerId);
	}

	@Override
	public Customer findCustomerById(int customerId) {
		return custDao.findCustomerById(customerId);
	}
}
