package cs157a.retailinWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs157a.retailinWebApp.dao.ReceiptDAO;
import cs157a.retailinWebApp.entity.Receipt;

@Service
public class ReceiptServiceImpl implements ReceiptService {
	@Autowired
	private ReceiptDAO receiptDao;
	
	@Override
	public List<Receipt> listReceipts() {
		return receiptDao.listReceipts();
	}

	@Override
	public void addReceipt(Receipt receipt) {
		receiptDao.addReceipt(receipt);
	}

	@Override
	public void updateReceipt(Receipt receipt) {
		receiptDao.updateReceipt(receipt);
	}

	@Override
	public void deleteReceipt(Integer receiptID) {
		receiptDao.deleteReceipt(receiptID);
	}

	@Override
	public Receipt getReceiptById(Integer receiptId) {
		return receiptDao.getReceiptById(receiptId);
	}

}
