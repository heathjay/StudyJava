package com.jay.java.Pattern.Facade;
/**
 * 办理注册公司流程的门面对象
 * @author jay
 *
 */
public class RegisterFacade {
	public void register() {
		NameCheck nc = new MyNameCheck();
		nc.checkName();
		TaxOffice tc = new MyTaxOffice();
		tc.checkTax();
		BankCheck bc = new MyBankCheck();
		bc.checkBank();
		
		
	}
}
