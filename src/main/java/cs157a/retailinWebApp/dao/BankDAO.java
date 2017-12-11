package cs157a.retailinWebApp.dao;

import java.util.List;

import cs157a.retailinWebApp.entity.BankAccount;

public interface BankDAO {
	public List<BankAccount> listBankAccounts();
	public void addBankAccount(BankAccount bankAccount);
	public void updateBankAccount(BankAccount bankAccount);
	public void deleteBankAccount(Integer bankId);
	public BankAccount getBankAccountById(Integer bankId);
}
