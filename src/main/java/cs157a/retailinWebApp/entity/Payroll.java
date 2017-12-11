package cs157a.retailinWebApp.entity;

public class Payroll {
	private int payrollID;
	private String payPeriod;
	private double hourlyRate;
	private int workedHours;
	private int empID;
	
	public Payroll() {
		// TODO Auto-generated constructor stub
	}

	public Payroll(int payrollID) {
		this.payrollID = payrollID;
	}

	public int getPayrollID() {
		return payrollID;
	}

	public void setPayrollID(int payrollID) {
		this.payrollID = payrollID;
	}

	public String getPayPeriod() {
		return payPeriod;
	}

	public void setPayPeriod(String payPeriod) {
		this.payPeriod = payPeriod;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public int getWorkedHours() {
		return workedHours;
	}

	public void setWorkedHours(int workedHours) {
		this.workedHours = workedHours;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}
}
