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
			paramSource.addValue("item_id", item.getItemID());
			paramSource.addValue("item_name", item.getItemName());
			paramSource.addValue("description", item.getDescription());
			paramSource.addValue("price", item.getPrice());
			paramSource.addValue("discount", item.getDiscount());
			paramSource.addValue("quantity", item.getQuantity());
			paramSource.addValue("category_id", item.getCategoryID());
		}
		return paramSource;
	}
	
	@Override
	public List<Item> getItems() {
		String sql = "SELECT * FROM items";
		List<Item> items = namedParameter.query(sql, getSqlParameterByModel(null), new ItemMapper());
		return items;
	}

	@Override
	public void addItem(Item item) {
		String sql = "INSERT INTO items(item_id, item_name, description, price, discount, quantity, category_id) "
				+ "VALUES(:item_id, :item_name, :description, :price, :discount, :quantity, :category_id)";
		namedParameter.update(sql, getSqlParameterByModel(item));
	}

	@Override
	public void updateItem(Item item) {
		String sql = "UPDATE items SET item_name = :item_name, description = :description, price = :price, discount = :discount, quantity = :quantity, category_id = :category_id "
				+ "WHERE item_id = :item_id";
		namedParameter.update(sql, getSqlParameterByModel(item));
	}

	@Override
	public void deleteItem(int itemId) {
		String sql = "DELETE FROM items where item_id = :item_id";
		namedParameter.update(sql, getSqlParameterByModel(new Item(itemId)));
	}

	@Override
	public Item findItemById(int itemId) {
		String sql = "SELECT * FROM items WHERE item_id = :item_id";
		return namedParameter.queryForObject(sql, getSqlParameterByModel(new Item(itemId)), new ItemMapper());
	}
}

class ItemMapper implements RowMapper<Item> {
	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		Item item = new Item();
		item.setItemID(rs.getInt("item_id"));
		item.setItemName(rs.getString("item_name"));
		item.setDescription(rs.getString("description"));
		item.setPrice(rs.getInt("price"));
		item.setDiscount(rs.getInt("discount"));
		item.setQuantity(rs.getInt("quantity"));
		item.setCategoryID(rs.getInt("category_id"));
		return item;
	}
}