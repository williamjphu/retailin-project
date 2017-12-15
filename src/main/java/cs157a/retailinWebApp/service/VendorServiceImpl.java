package cs157a.retailinWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs157a.retailinWebApp.dao.VendorDAO;
import cs157a.retailinWebApp.entity.Vendor;

@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorDAO vendorDao;
	
	@Override
	public List<Vendor> listVendors() {
		return vendorDao.listVendors();
	}

	@Override
	public void addVendor(Vendor vendor) {
		vendorDao.addVendor(vendor);
	}

	@Override
	public void updateVendor(Vendor vendor) {
		vendorDao.updateVendor(vendor);
	}

	@Override
	public void deleteVendor(Integer vendorId) {
		vendorDao.deleteVendor(vendorId);
	}

	@Override
	public Vendor getVendorById(Integer vendorId) {
		return vendorDao.getVendorById(vendorId);
	}
}
