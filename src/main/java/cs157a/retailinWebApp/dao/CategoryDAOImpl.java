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

import cs157a.retailinWebApp.entity.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	NamedParameterJdbcTemplate namedParameter;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameter) throws DataAccessException {
		this.namedParameter = namedParameter;
	}
	
	private SqlParameterSource getParameterByModel(Category category) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (category != null) {
			paramSource.addValue("category_id", category.getCategoryID());
			paramSource.addValue("name", category.getName());
			paramSource.addValue("description", category.getDescription());
		}
		return paramSource;
	}
	
	@Override
	public List<Category> listCategories() {
		String sql = "SELECT * FROM categories";
		List<Category> categories = namedParameter.query(sql, getParameterByModel(null),	new CategoryMapper());
		return categories;
	}

	@Override
	public void addCategory(Category category) {
		String sql = "INSERT INTO categories(category_id, name, description) "
				+ "VALUES(:category_id, :name, :description)";
		namedParameter.update(sql, getParameterByModel(category));
	}

	@Override
	public void updateCategory(Category category) {
		String sql = "UPDATE categories SET name = :name, description = :description "
				+ "WHERE category_id = :category_id";
		namedParameter.update(sql, getParameterByModel(category));
	}

	@Override
	public void deleteCategory(Integer catID) {
		String sql = "DELETE FROM categories WHERE category = :category_id";
		namedParameter.update(sql, getParameterByModel(new Category(catID)));
	}

	@Override
	public Category getCategoryById(Integer catID) {
		String sql = "SELECT * FROM categories WHERE category_id = :category_id";
		return namedParameter.queryForObject(sql, getParameterByModel(new Category(catID)), new CategoryMapper());
	}
	
}

class CategoryMapper implements RowMapper<Category> {
	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category cat = new Category();
		cat.setCategoryID(rs.getInt("category_id"));
		cat.setName(rs.getString("name"));
		cat.setDescription(rs.getString("description"));
		return cat;
	}
}