package cs157a.retailinWebApp.dao;

import java.util.List;

import cs157a.retailinWebApp.entity.Payroll;

public interface PayrollDAO {
	public List<Payroll> listPayrolls();
	public void addPayroll(Payroll payroll);
	public void updatePayroll(Payroll payroll);
	public void deletePayroll(Integer payID);
	public Payroll getPayrollById(Integer payID);
}
