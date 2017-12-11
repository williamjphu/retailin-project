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

import cs157a.retailinWebApp.entity.Payroll;

@Repository
public class PayrollDAOImpl implements PayrollDAO {
	@Autowired
	NamedParameterJdbcTemplate namedParamter;
	
	@Autowired
	public void setNamedParamter(NamedParameterJdbcTemplate namedParamter) {
		this.namedParamter = namedParamter;
	}
	
	private SqlParameterSource getParameterByModel(Payroll pay) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (pay != null) {
			paramSource.addValue("payroll_id", pay.getPayrollID());
			paramSource.addValue("pay_period", pay.getPayPeriod());
			paramSource.addValue("hourly_rate", pay.getHourlyRate());
			paramSource.addValue("worked_hours", pay.getWorkedHours());
			paramSource.addValue("emp_id", pay.getEmpID());
		}
		return paramSource;
	}
	@Override
	public List<Payroll> listPayrolls() {
		String sql = "SELECT * FROM payrolls";
		List<Payroll> payrolls = namedParamter.query(sql, getParameterByModel(null), new PayrollMapper());
		return payrolls;
	}

	@Override
	public void addPayroll(Payroll payroll) {
		String sql = "INSERT INTO payrolls(payroll_id, pay_period, hourly_rate, worked_hours, emp_id) "
				+ "VALUES(:payroll_id, :pay_period, :hourly_rate, :worked_hours, :emp_id)";
		namedParamter.update(sql, getParameterByModel(payroll));
	}

	@Override
	public void updatePayroll(Payroll payroll) {
		String sql = "UPDATE payrolls SET pay_period = :pay_period, hourly_rate = :hourly_rate, "
				+ "worked_hours = :worked_hours, emp_id = :emp_id WHERE payroll_id = :payroll_id";
		namedParamter.update(sql, getParameterByModel(payroll));
	}

	@Override
	public void deletePayroll(Integer payID) {
		String sql = "DELETE FROM payrolls WHERE payroll_id = :payroll_id";
		namedParamter.update(sql, getParameterByModel(new Payroll(payID)));
	}

	@Override
	public Payroll getPayrollById(Integer payID) {
		String sql = "SELECT * FROM payrolls WHERE payroll_id = :payroll_id";
		return namedParamter.queryForObject(sql, getParameterByModel(new Payroll(payID)), new PayrollMapper());
	}
}

class PayrollMapper implements RowMapper<Payroll> {
	@Override
	public Payroll mapRow(ResultSet rs, int rowNum) throws SQLException {
		Payroll pay = new Payroll();
		pay.setPayrollID(rs.getInt("payroll_id"));
		pay.setPayPeriod(rs.getString("pay_period"));
		pay.setHourlyRate(rs.getDouble("hourly_rate"));
		pay.setWorkedHours(rs.getInt("worked_hours"));
		pay.setEmpID(rs.getInt("emp_id"));
		return pay;
	}
}