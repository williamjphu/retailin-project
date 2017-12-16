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

import cs157a.retailinWebApp.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	NamedParameterJdbcTemplate namedParameter;
	
	public void setNamedParameter(NamedParameterJdbcTemplate namedParameter) throws DataAccessException {
		this.namedParameter = namedParameter;
	}
	
	private SqlParameterSource getSqlParameterByModel(User user) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (user != null) {
			paramSource.addValue("username", user.getEmpID());
			paramSource.addValue("last_name", user.getLastName());
			paramSource.addValue("first_name", user.getFirstName());
			paramSource.addValue("password", user.getPassword());
			paramSource.addValue("email", user.getEmail());
			paramSource.addValue("phone_number", user.getPhoneNumber());
			paramSource.addValue("enabled", user.getEnabled());
			paramSource.addValue("authority", user.getAuthority());
			paramSource.addValue("department_id", user.getDepartmentID());
		}
		return paramSource;
	}
	
	
	@Override
	public List<User> getUsers() {
		String sql = "Select * FROM users";
		List<User> users = namedParameter.query(sql, getSqlParameterByModel(null), new UserMapper());
		return users;
	}

	@Override
	public void addUser(User user) {
		String sql = "INSERT INTO users(username, last_name, first_name, password, email, "
				+ "phone_number, enabled, authority, department_id) "
				+ "VALUES(:username, :last_name, :first_name, :password, :email, "
				+ ":phone_number, :enabled, :authority, :department_id)";
		namedParameter.update(sql, getSqlParameterByModel(user));
		String sql2 = "INSERT INTO authorities(username, authority) SELECT username, authority "
				+ "FROM users ORDER BY username DESC LIMIT 1";
		namedParameter.update(sql2, getSqlParameterByModel(user));
	}
	
	@Override
	public void updateUser(User user) {
		String sql = "UPDATE users SET last_name = :last_name, first_name = :first_name, "
				+ "password = :password, email = :email, "
				+ "phone_number = :phone_number, enabled = :enabled, authority = :authority, "
				+ "department_id = :department_id "
				+ "WHERE username = :username";
		namedParameter.update(sql, getSqlParameterByModel(user));
		String sql2 = "UPDATE authorities SET authority = :authority WHERE username = :username";
		namedParameter.update(sql2, getSqlParameterByModel(user));
	}

	@Override
	public void deleteUser(Integer empID) {
		String sql = "DELETE FROM authorities WHERE username = :username";
		namedParameter.update(sql, getSqlParameterByModel(new User(empID)));
		String sql2 = "DELETE FROM users WHERE username = :username";
		namedParameter.update(sql2, getSqlParameterByModel(new User(empID)));
	}
	
	@Override
	public User getUserById(Integer empID) {
		String sql = "SELECT * FROM users WHERE username = :username";
		return namedParameter.queryForObject(sql, getSqlParameterByModel(new User(empID)), new UserMapper());
	}
}

class UserMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setEmpID(rs.getInt("username"));
		user.setLastName(rs.getString("last_name"));
		user.setFirstName(rs.getString("first_name"));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		user.setPhoneNumber(rs.getString("phone_number"));
		user.setEnabled(rs.getInt("enabled"));
		user.setAuthority(rs.getString("authority"));
		user.setDepartmentID(rs.getInt("department_id"));
		return user;
	}
}