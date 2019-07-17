package com.sango.java8.model;

import java.util.List;
import java.util.Set;

public class AccountDetail {

	private List<String> accountName;
	private int accountAge;
	private String accountStatus;
	private String accountHolderFullName;
	
	public AccountDetail(List<String> accountName, int accountAge, String accountStatus, String accountHolderFullName) {
		super();
		this.accountName = accountName;
		this.accountAge = accountAge;
		this.accountStatus = accountStatus;
		this.accountHolderFullName = accountHolderFullName;
	}

	public List<String> getAccountName() {
		return accountName;
	}

	public void setAccountName(List<String> accountName) {
		this.accountName = accountName;
	}

	public int getAccountAge() {
		return accountAge;
	}

	public void setAccountAge(int accountAge) {
		this.accountAge = accountAge;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getAccountHolderFullName() {
		return accountHolderFullName;
	}

	public void setAccountHolderFullName(String accountHolderFullName) {
		this.accountHolderFullName = accountHolderFullName;
	}

	@Override
	public String toString() {
		return "AccountDetail [accountName=" + accountName + ", accountAge=" + accountAge + ", accountStatus="
				+ accountStatus + ", accountHolderFullName=" + accountHolderFullName + "]";
	}
	
	
	
}
