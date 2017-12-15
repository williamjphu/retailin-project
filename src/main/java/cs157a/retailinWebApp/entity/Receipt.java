package cs157a.retailinWebApp.entity;

public class Receipt {
	private int transactionNo;
	private double total;
	private String timestamp;
	private int empID;
	private int customerID;
	
	public Receipt() {
		// TODO Auto-generated constructor stub
	}

	public Receipt(int transactionNo) {
		this.transactionNo = transactionNo;
	}

	public int getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(int transactionNo) {
		this.transactionNo = transactionNo;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
}