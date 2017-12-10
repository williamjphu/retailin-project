package cs157a.retailinWebApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import cs157a.retailinWebApp.entity.Department;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
	@Autowired
	NamedParameterJdbcTemplate namedParameter;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameter) {
		this.namedParameter = namedParameter;
	}
	
	private SqlParameterSource getParameterByModel(Department dept) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (dept != null) {
			paramSource.addValue("dept_id", dept.getDeptID());
			paramSource.addValue("name", dept.getName());
			paramSource.addValue("description", dept.getDescription());
		}
		return paramSource;
	}
	
	@Override
	public List<Department> listDepartments() {
		String sql = "SELECT * FROM departments";
		List<Department> depts = namedParameter.query(sql, getParameterByModel(null), new DepartmentMapper());
		return depts;
	}

	@Override
	public void addDepartment(Department dept) {
		String sql = "INSERT INTO departments(dept_id, name, description) "
				+ "VALUES(:dept_id, :name, :description)";
		namedParameter.update(sql, getParameterByModel(dept));
	}

	@Override
	public void updateDepartment(Department dept) {
		String sql = "UPDATE departments SET name = :name, description = :description "
				+ "WHERE dept_id = :dept_id";
		namedParameter.update(sql, getParameterByModel(dept));
	}

	@Override
	public void deleteDepartment(Integer deptID) {
		String sql = "DELETE FROM departments WHERE dept_id = :dept_id";
		namedParameter.update(sql, getParameterByModel(new Department(deptID)));
	}

	@Override
	public Department getDepartmentById(Integer deptID) {
		String sql = "SELECT * FROM departments where dept_id = :dept_id";
		return namedParameter.queryForObject(sql, getParameterByModel(new Department(deptID)), new DepartmentMapper());
	}
}

class DepartmentMapper implements RowMapper<Department> {
	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		Department dept = new Department();
		dept.setDeptID(rs.getInt("dept_id"));
		dept.setName(rs.getString("name"));
		dept.setDescription(rs.getString("description"));
		return dept;
	}
}