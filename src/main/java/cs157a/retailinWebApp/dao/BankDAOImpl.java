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

import cs157a.retailinWebApp.entity.BankAccount;

@Repository
public class BankDAOImpl implements BankDAO {
	@Autowired
	NamedParameterJdbcTemplate namedParamter;
	
	@Autowired
	public void setNamedParamter(NamedParameterJdbcTemplate namedParamter) throws DataAccessException {
		this.namedParamter = namedParamter;
	}
	
	private SqlParameterSource getParameterByModel(BankAccount bank) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (bank != null) {
			paramSource.addValue("acct_id", bank.getAcctID());
			paramSource.addValue("acct_no", bank.getAcctNumber());
			paramSource.addValue("routing_no", bank.getRoutingNumber());
			paramSource.addValue("acct_type", bank.getAcctType());
			paramSource.addValue("name", bank.getBankName());
			paramSource.addValue("address", bank.getBankAddress());
			paramSource.addValue("city", bank.getBankCity());
			paramSource.addValue("state", bank.getBankState());
			paramSource.addValue("zip_code", bank.getZipCode());
			paramSource.addValue("emp_id", bank.getEmpID());
		}
		return paramSource;
	}
	@Override
	public List<BankAccount> listBankAccounts() {
		String sql = "SELECT * FROM bank_accounts";
		List<BankAccount> accounts = namedParamter.query(sql, getParameterByModel(null), new BankMapper());
		return accounts;
	}

	@Override
	public void addBankAccount(BankAccount bankAccount) {
		String sql = "INSERT INTO bank_accounts(acct_id, acct_no, routing_no, acct_type, name, address, city, state, zip_code, emp_id) "
				+ "VALUES(:acct_id, :acct_no, :routing_no, :acct_type, :name, :address, :city, :state, :zip_code, :emp_id)";
		namedParamter.update(sql, getParameterByModel(bankAccount));
	}

	@Override
	public void updateBankAccount(BankAccount bankAccount) {
		String sql = "UPDATE bank_accounts SET acct_no = :acct_no, routing_no = :routing_no, acct_type = :acct_type, name = :name, "
				+ "address = :address, city = :city, state = :state, zip_code = :zip_code, emp_id = :emp_id "
				+ "WHERE acct_id = :acct_id";
		namedParamter.update(sql, getParameterByModel(bankAccount));
	}

	@Override
	public void deleteBankAccount(Integer bankId) {
		String sql = "DELETE FROM bank_accounts WHERE acct_id = :acct_id";
		namedParamter.update(sql, getParameterByModel(new BankAccount(bankId)));
	}

	@Override
	public BankAccount getBankAccountById(Integer bankId) {
		String sql = "SELECT * FROM bank_accounts WHERE acct_id = :acct_id";
		return namedParamter.queryForObject(sql, getParameterByModel(new BankAccount(bankId)), new BankMapper());
	}
}

class BankMapper implements RowMapper<BankAccount> {
	@Override
	public BankAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
		BankAccount pay = new BankAccount();
		pay.setAcctID(rs.getInt("acct_id"));
		pay.setAcctNumber(rs.getLong("acct_no"));
		pay.setRoutingNumber(rs.getLong("routing_no"));
		pay.setAcctType(rs.getString("acct_type"));
		pay.setBankName(rs.getString("name"));
		pay.setBankAddress(rs.getString("address"));
		pay.setBankCity(rs.getString("city"));
		pay.setBankState(rs.getString("state"));
		pay.setZipCode(rs.getInt("zip_code"));
		pay.setEmpID(rs.getInt("emp_id"));
		return pay;
	}
}