package com.jay.java.Pattern.Facade;

public interface TaxOffice {
	public void checkTax();
}

class MyTaxOffice implements TaxOffice{
	@Override
	public void checkTax() {
		System.out.println("Tax check");
	}
}
