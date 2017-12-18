package cs157a.retailinWebApp.dao;

import java.util.List;

import cs157a.retailinWebApp.entity.Item;
import cs157a.retailinWebApp.entity.Receipt;

public interface ReceiptDAO {
	public List<Receipt> listReceipts();
	public void addReceipt(Receipt receipt);
	public void updateReceipt(Receipt receipt);
	public void deleteReceipt(Integer receiptID);
	public Receipt getReceiptById(Integer receiptId);
	public void addReceipt(Receipt receipt, List<Item> items);
}
