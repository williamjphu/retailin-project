package cs157a.retailinWebApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import cs157a.retailinWebApp.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	NamedParameterJdbcTemplate namedParameter;
	
	@Autowired
	public void setNamedParameter(NamedParameterJdbcTemplate namedParameter) throws DataAccessException {
		this.namedParameter = namedParameter;
	}
	
	private SqlParameterSource getSqlParameterByModel(Customer cust) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (cust != null) {
			paramSource.addValue("customer_id", cust.getCustomerID());
			paramSource.addValue("phone_number", cust.getPhoneNumber());
			paramSource.addValue("first_name", cust.getFirstName());
			paramSource.addValue("last_name", cust.getLastName());
			paramSource.addValue("email", cust.getEmail());
			paramSource.addValue("zip_code", cust.getZipCode());
		}
		return paramSource;
	}
	
	@Override
	public List<Customer> listCustomers() {
		String sql = "SELECT * FROM customers";
		List<Customer> customers = namedParameter.query(sql, getSqlParameterByModel(null), new CustomerMapper());
		return customers;
	}

	@Override
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO customers(customer_id, phone_number, first_name, last_name, email, zip_code) "
				+ "VALUES(:customer_id, :phone_number, :first_name, :last_name, :email, :zip_code)";
		namedParameter.update(sql, getSqlParameterByModel(customer));
	}

	@Override
	public void updateCustomer(Customer customer) {
		String sql = "UPDATE customers SET phone_number = :phone_number, first_name = :first_name, last_name = :last_name, email = :email, "
				+ "zip_code = :zip_code WHERE customer_id = :customer_id";
		namedParameter.update(sql, getSqlParameterByModel(customer));
	}

	@Override
	public void deleteCustomer(int customerId) {
		String sql = "DELETE FROM customers WHERE customer_id = :customer_id";
		namedParameter.update(sql, getSqlParameterByModel(new Customer(customerId)));
	}

	@Override
	public Customer findCustomerById(int customerId) {
		String sql = "SELECT * FROM customers WHERE customer_id = :customer_id";
		return namedParameter.queryForObject(sql, getSqlParameterByModel(new Customer(customerId)), new CustomerMapper());
	}
	
	
//	@Autowired
//	private SessionFactory sessionFactory;
//	
//	@Override
//	public List<Customer> getCustomers() {
//		Session currentSession = sessionFactory.getCurrentSession();
//		Query<Customer> queries = currentSession.createQuery("from Customer", Customer.class);
//		List<Customer> customers = queries.getResultList();
//		return customers;
//	}
//
//	@Override
//	public void saveCustomer(Customer customer) {
//		Session currentSession = sessionFactory.getCurrentSession();
//		currentSession.saveOrUpdate(customer);
//	}
//
//	@Override
//	public Customer getCustomer(Integer phoneNo) {
//		Session currentSession = sessionFactory.getCurrentSession();
//		Customer cust = currentSession.get(Customer.class, phoneNo);
//		return cust;
//	}
//
//	@Override
//	public void deleteCustomer(Integer phoneNo) {
//		Session currentSession = sessionFactory.getCurrentSession();
//		// delete object with primary key
//		Query theQuery = currentSession.createQuery("delete from Customer where phoneNumber=:customerID");
//		theQuery.setParameter("customerID", phoneNo);
//		// execute query
//		theQuery.executeUpdate();
//	}
}

class CustomerMapper implements RowMapper<Customer> {
	public Customer mapRow(ResultSet rs, int rowNun) throws SQLException {
		Customer cust = new Customer();
		cust.setCustomerID(rs.getInt("customer_id"));
		cust.setPhoneNumber(rs.getLong("phone_number"));
		cust.setFirstName(rs.getString("first_name"));
		cust.setLastName(rs.getString("last_name"));
		cust.setEmail(rs.getString("email"));
		cust.setZipCode(rs.getInt("zip_code"));
		return cust;
	}	
}
