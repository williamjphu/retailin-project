package cs157a.retailinWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs157a.retailinWebApp.dao.BankDAO;
import cs157a.retailinWebApp.entity.BankAccount;

@Service
public class BankServiceImpl implements BankService {
	@Autowired
	private BankDAO bankDao;
	
	@Override
	public List<BankAccount> listBankAccounts() {
		return bankDao.listBankAccounts();
	}

	@Override
	public void addBankAccount(BankAccount bankAccount) {
		bankDao.addBankAccount(bankAccount);
	}

	@Override
	public void updateBankAccount(BankAccount bankAccount) {
		bankDao.updateBankAccount(bankAccount);
	}

	@Override
	public void deleteBankAccount(Integer bankId) {
		bankDao.deleteBankAccount(bankId);
	}

	@Override
	public BankAccount getBankAccountById(Integer bankId) {
		return bankDao.getBankAccountById(bankId);
	}

}
