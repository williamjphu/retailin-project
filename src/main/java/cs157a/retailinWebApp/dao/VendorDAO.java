package cs157a.retailinWebApp.dao;

import java.util.List;

import cs157a.retailinWebApp.entity.Vendor;

public interface VendorDAO {
	public List<Vendor> listVendors();
	public void addVendor(Vendor vendor);
	public void updateVendor(Vendor vendor);
	public void deleteVendor(Integer vendorId);
	public Vendor getVendorById(Integer vendorId);
}
