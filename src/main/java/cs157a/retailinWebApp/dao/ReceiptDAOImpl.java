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

import cs157a.retailinWebApp.entity.Receipt;

@Repository
public class ReceiptDAOImpl implements ReceiptDAO {
	@Autowired
	NamedParameterJdbcTemplate namedParameter;
	
	@Autowired
	public void setNamedParameter(NamedParameterJdbcTemplate namedParameter) throws DataAccessException {
		this.namedParameter = namedParameter;
	}
	
	private SqlParameterSource getParameterByModel(Receipt receipt) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (receipt != null) {
			paramSource.addValue("transaction_no", receipt.getTransactionNo());
			paramSource.addValue("total", receipt.getTotal());
			paramSource.addValue("receipt_date", receipt.getTimestamp());
			paramSource.addValue("emp_id", receipt.getEmpID());
			paramSource.addValue("customer_id", receipt.getCustomerID());
		}
		return paramSource;
	}
	@Override
	public List<Receipt> listReceipts() {
		String sql = "SELECT * FROM receipts";
		List<Receipt> receipts = namedParameter.query(sql, getParameterByModel(null), new ReceiptMapper());
		return receipts;
	}

	@Override
	public void addReceipt(Receipt receipt) {
		String sql = "INSERT INTO receipts(transaction_no, total, emp_id, customer_id) "
				+ "VALUES(:transaction_no, :total, :emp_id, :customer_id)";
		namedParameter.update(sql, getParameterByModel(receipt));
	}

	@Override
	public void updateReceipt(Receipt receipt) {
		String sql = "UPDATE receipts SET total = :total, emp_id = :emp_id, customer_id = :customer_id "
				+ "WHERE transaction_no = :transaction_no";
		namedParameter.update(sql, getParameterByModel(receipt));
	}

	@Override
	public void deleteReceipt(Integer receiptId) {
		String sql = "DELETE FROM receipts WHERE transaction_no = :transaction_no";
		namedParameter.update(sql, getParameterByModel(new Receipt(receiptId)));
	}

	@Override
	public Receipt getReceiptById(Integer receiptId) {
		String sql = "SELECT * FROM receipts WHERE transaction_no = :transaction_no";
		return namedParameter.queryForObject(sql, getParameterByModel(new Receipt(receiptId)), new ReceiptMapper());
	}
}

class ReceiptMapper implements RowMapper<Receipt> {
	@Override
	public Receipt mapRow(ResultSet rs, int rowNum) throws SQLException {
		Receipt rec = new Receipt();
		rec.setTransactionNo(rs.getInt("transaction_no"));
		rec.setTotal(rs.getDouble("total"));
		rec.setTimestamp(rs.getString("receipt_date"));
		rec.setEmpID(rs.getInt("emp_id"));
		rec.setCustomerID(rs.getInt("customer_id"));
		return rec;
	}	
}
