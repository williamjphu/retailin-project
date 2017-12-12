package cs157a.retailinWebApp.service;

import java.util.List;

import cs157a.retailinWebApp.entity.Receipt;

public interface ReceiptService {
	public List<Receipt> listReceipts();
	public void addReceipt(Receipt receipt);
	public void updateReceipt(Receipt receipt);
	public void deleteReceipt(Integer receiptID);
	public Receipt getReceiptById(Integer receiptId);
}
