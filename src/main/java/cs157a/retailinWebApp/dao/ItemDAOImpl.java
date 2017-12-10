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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import cs157a.retailinWebApp.entity.Item;

@Repository
public class ItemDAOImpl implements ItemDAO {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameter;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameter) throws DataAccessException {
		this.namedParameter = namedParameter;
	}
	
	private SqlParameterSource getSqlParameterByModel(Item item) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (item != null) {
			paramSource.addValue("item_name", item.getItemName());
			paramSource.addValue("description", item.getDescription());
			paramSource.addValue("price", item.getPrice());
			paramSource.addValue("discount", item.getDiscount());
			paramSource.addValue("quantity", item.getQuantity());
			paramSource.addValue("category_id", item.getCategoryID());
		}
		return paramSource;
	}
	
	private static final class ItemMapper implements RowMapper<Item> {
		public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
			Item item = new Item();
			item.setItemName(rs.getString("item_name"));
			item.setDescription(rs.getString("description"));
			item.setPrice(rs.getInt("price"));
			item.setDiscount(rs.getInt("discount"));
			item.setQuantity(rs.getInt("quantity"));
			item.setCategoryID(rs.getInt("category_id"));
			return item;
		}
	}
	
	@Override
	public List<Item> getItems() {
		String sql = "SELECT item_name, description, price, discount, quantity, category_id FROM items";
		List<Item> items = namedParameter.query(sql, getSqlParameterByModel(null), new ItemMapper());
		return items;
	}

	@Override
	public void addItem(Item item) {
		String sql = "INSERT INTO items(item_name, description, price, discount, quantity, category_id) "
				+ "VALUES(:item_name, :description, :price, :discount, :quantity, :category_id)";
		namedParameter.update(sql, getSqlParameterByModel(item));
	}

	@Override
	public void updateItem(Item item) {
		String sql = "UPDATE items SET description = :description, price = :price, discount = :discount, quantity = :quantity, category_id = :category_id "
				+ "WHERE item_name = :item_name";
		namedParameter.update(sql, getSqlParameterByModel(item));
	}

	@Override
	public void deleteItem(String itemName) {
		String sql = "DELETE FROM items where item_name = :item_name";
		namedParameter.update(sql, getSqlParameterByModel(new Item(itemName)));
	}

	@Override
	public Item findItemById(String itemName) {
		String sql = "SELECT * FROM items WHERE item_name = :item_name";
		return namedParameter.queryForObject(sql, getSqlParameterByModel(new Item(itemName)), new ItemMapper());
	}
//	@Autowired
//	private SessionFactory sessionFactory; 
////	@Autowired JdbcTemplate jdbcTemplate;
//	
//	@Override
//	public List<Item> getItems() {
//		Session currentSession = sessionFactory.getCurrentSession();
//		Query<Item> query = currentSession.createQuery("from Item", Item.class); 
//		List<Item> items = query.getResultList();
//		return items;
//	}
//
//	@Override
//	public void saveItem(Item item) {
//		// get current hibernate session
//		Session currentSession = sessionFactory.getCurrentSession();
//		
////		if(theUser.empID < 1) {
//			SQLQuery q = currentSession.createSQLQuery("insert into items(item_name, description, price, discount, quantity, category_id)" + 
//					" values(?, ?, ?, ?, ?, ?)");
//			q.setParameter(0, item.getItemName());
//			q.setParameter(1, item.getDescription());
//			q.setParameter(2, item.getPrice());
//			q.setParameter(3, item.getDiscount());
//			q.setParameter(4, item.getQuantity());
//			q.setParameter(5, item.getCategoryID());
//			q.executeUpdate();
////			SQLQuery q3 = currentSession.createSQLQuery("insert into categories(category_name, category_description) select category_id from items order by category_id desc limit 1");
////			q3.executeUpdate();
////		}
////		else {
////			SQLQuery q = currentSession.createSQLQuery("update users set first_name = ?, last_name = ?, password = ?, email = ?, phone_number = ?, enabled = ?, authority = ?, department_id = ? where username = ?");
////			q.setParameter(0, theUser.getFirstName());
////			q.setParameter(1, theUser.getLastName());
////			q.setParameter(2, theUser.getPassword());
////			q.setParameter(3, theUser.getEmail());
////			q.setParameter(4, theUser.getPhoneNumber());
////			q.setParameter(5, theUser.getEnabled());
////			q.setParameter(6, theUser.getAuthority());
////			q.setParameter(7, theUser.getDepartmentID());
////			q.setParameter(8, theUser.empID);
////			q.executeUpdate();
////			SQLQuery q3 = currentSession.createSQLQuery("update authorities set authority = ? where username = ?");
////			q3.setParameter(0, theUser.getAuthority());
////			q3.setParameter(1, theUser.empID);
////			q3.executeUpdate();
////		}
//		// save/update the customer
////		currentSession.saveOrUpdate(item);
//		
//	}
//
//	@Override
//	public Item getItem(String itemN) {
//		Session currentSession = sessionFactory.getCurrentSession();
//		Item item = currentSession.get(Item.class, itemN);
//		return item;
//	}
//
//	@Override
//	public void deleteItem(String itemN) {
//		Session currentSession = sessionFactory.getCurrentSession();
//		// delete object with primary key
//		Query theQuery = currentSession.createQuery("delete from Item where itemName=:itemNAME");
//		theQuery.setParameter("itemNAME", itemN);
//		// execute query
//		theQuery.executeUpdate();
//	}
}
