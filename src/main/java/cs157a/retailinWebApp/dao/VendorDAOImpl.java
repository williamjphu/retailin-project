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

import cs157a.retailinWebApp.entity.Vendor;

@Repository
public class VendorDAOImpl implements VendorDAO {
	@Autowired
	NamedParameterJdbcTemplate namedParamter;
	
	@Autowired
	public void setNamedParamter(NamedParameterJdbcTemplate namedParamter) throws DataAccessException {
		this.namedParamter = namedParamter;
	}
	
	private SqlParameterSource getParameterByModel(Vendor vendor) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (vendor != null) {
			paramSource.addValue("vendor_id", vendor.getVendorID());
			paramSource.addValue("ein", vendor.getEin());
			paramSource.addValue("name", vendor.getName());
			paramSource.addValue("address", vendor.getAddress());
			paramSource.addValue("city", vendor.getCity());
			paramSource.addValue("state", vendor.getState());
			paramSource.addValue("zip_code", vendor.getZipCode());
		}
		return paramSource;
	}
	@Override
	public List<Vendor> listVendors() {
		String sql = "SELECT * FROM vendors ORDER BY name";
		List<Vendor> Vendors = namedParamter.query(sql, getParameterByModel(null), new VendorMapper());
		return Vendors;
	}

	@Override
	public void addVendor(Vendor vendor) {
		String sql = "INSERT INTO vendors(vendor_id, ein, name, address, city, state, zip_code) "
				+ "VALUES(:vendor_id, :ein, :name, :address, :city, :state, :zip_code)";
		namedParamter.update(sql, getParameterByModel(vendor));
	}

	@Override
	public void updateVendor(Vendor vendor) {
		String sql = "UPDATE vendors SET ein = :ein, name = :name, address = :address, city = :city, state = :state, zip_code = :zip_code "
				+ "WHERE vendor_id = :vendor_id";
		namedParamter.update(sql, getParameterByModel(vendor));
	}

	@Override
	public void deleteVendor(Integer vendorId) {
		String sql = "DELETE FROM vendors WHERE vendor_id = :vendor_id";
		namedParamter.update(sql, getParameterByModel(new Vendor(vendorId)));
	}

	@Override
	public Vendor getVendorById(Integer vendorId) {
		String sql = "SELECT * FROM vendors WHERE vendor_id = :vendor_id";
		return namedParamter.queryForObject(sql, getParameterByModel(new Vendor(vendorId)), new VendorMapper());
	}
}

class VendorMapper implements RowMapper<Vendor> {
	@Override
	public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vendor vendor = new Vendor();
		vendor.setVendorID(rs.getInt("vendor_id"));
		vendor.setEin(rs.getString("ein"));
		vendor.setName(rs.getString("name"));
		vendor.setAddress(rs.getString("address"));
		vendor.setCity(rs.getString("city"));
		vendor.setState(rs.getString("state"));
		vendor.setZipCode(rs.getInt("zip_code"));
		return vendor;
	}
}