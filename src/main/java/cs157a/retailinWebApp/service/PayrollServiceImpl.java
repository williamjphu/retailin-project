package cs157a.retailinWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs157a.retailinWebApp.dao.PayrollDAO;
import cs157a.retailinWebApp.entity.Payroll;

@Service
public class PayrollServiceImpl implements PayrollService {
	@Autowired
	private PayrollDAO payrollDao;
	
	@Override
	public List<Payroll> listPayrolls() {
		return payrollDao.listPayrolls();
	}

	@Override
	public void addPayroll(Payroll payroll) {
		payrollDao.addPayroll(payroll);
	}

	@Override
	public void updatePayroll(Payroll payroll) {
		payrollDao.updatePayroll(payroll);
	}

	@Override
	public void deletePayroll(Integer payID) {
		payrollDao.deletePayroll(payID);
	}

	@Override
	public Payroll getPayrollById(Integer payID) {
		return payrollDao.getPayrollById(payID);
	}
}
