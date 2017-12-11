package cs157a.retailinWebApp.service;

import java.util.List;

import cs157a.retailinWebApp.entity.Payroll;

public interface PayrollService {
	public List<Payroll> listPayrolls();
	public void addPayroll(Payroll payroll);
	public void updatePayroll(Payroll payroll);
	public void deletePayroll(Integer payID);
	public Payroll getPayrollById(Integer payID);
}
