package com.sango.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sango.java8.model.AccountDetail;

public class StreamMain {

	public static void main(String[] args) {
		List<AccountDetail> listAccountDetail = new ArrayList<>();

		listAccountDetail.add(new AccountDetail(Arrays.asList("Chase Freedom Card","Auto Loan"), 15, "Open", "Iron Man"));
		listAccountDetail.add(new AccountDetail(Arrays.asList("Chase Saphaire Card", "Home Loan"), 4, "Closed", "Captain America"));
		listAccountDetail.add(new AccountDetail(Arrays.asList("Chase Unlimited Freedom Card","AMEX"), 3, "Open", "The Hulk"));
		listAccountDetail.add(new AccountDetail(Arrays.asList("Chase Freedom Card","City"), 8, "Closed", "Dr Strange"));
		listAccountDetail.add(new AccountDetail(Arrays.asList("Chase Saphaire Card","Capitol One"), 2, "OPEN", "Antman"));
		listAccountDetail.add(new AccountDetail(Arrays.asList("Chase Unlimited Freedom Card", "Auto Loan"), 1, "Open", "Spriderman"));
		listAccountDetail.add(new AccountDetail(Arrays.asList("Chase Freedom Card","AMEX"), 3, "Open", "Widow"));
		listAccountDetail.add(new AccountDetail(Arrays.asList("Chase Freedom Card","Amex"), 8, "Closed", "Thor"));
		listAccountDetail.add(new AccountDetail(Arrays.asList("Chase Saphaire Card","BoA","Capitol One"), 2, "OPEN", "Hawk Eye"));
		listAccountDetail.add(new AccountDetail(Arrays.asList("Chase Unlimited Freedom Card", "Auto Loan"), 1, "Open", "Captian Marvel"));
		listAccountDetail.add(new AccountDetail(Arrays.asList("Chase Saphaire Reserve", "Auto Loan"), 20, "Open", "Nick Fury"));
		listAccountDetail.add(new AccountDetail(Arrays.asList("Chase Unlimited Freedom Card","Chase Saphaire Reserve", "Auto Loan"), 19, "Open", "Star Lord"));
		
		Map<String,List<String>> personMap = new HashMap<String,List<String>>();
		personMap.put("Iron Man", Arrays.asList("Knowledge","Arc Reactor","Super smart"));
		personMap.put("The Hulk", Arrays.asList("Knowledge","Gama Rediation","Super streangth"));
		personMap.put("Dr Strange", Arrays.asList("Knowledge","Time Infinity Stone","Super smart","Draws power from other universes"));
		personMap.put("Captain Marvel", Arrays.asList("Grit","Teasract"));
		
		List<AccountDetail> openAccountList = listAccountDetail.stream()
				.filter(accountDetail -> accountDetail.getAccountStatus().equalsIgnoreCase("Open"))
				.collect(Collectors.toList());

		// openAccountList.forEach(list -> System.out.println(list));
		System.out.println("**********");

		List<AccountDetail> openAccountAgeSortedList = listAccountDetail.stream()
				.filter(accountDetail -> accountDetail.getAccountStatus().equalsIgnoreCase("Open"))
				.sorted(Comparator.comparing(AccountDetail::getAccountAge)).collect(Collectors.toList());

		// openAccountAgeSortedList.forEach(list -> System.out.println(list));
		System.out.println("**********");

		List<AccountDetail> openAccountAgeReverseSortedList = listAccountDetail.stream()
				.filter(accountDetail -> accountDetail.getAccountStatus().equalsIgnoreCase("Open"))
				.sorted(Comparator.comparing(AccountDetail::getAccountAge).reversed()).collect(Collectors.toList());

		//openAccountAgeReverseSortedList.forEach(list -> System.out.println(list));

		System.out.println("**********");

		List<String> openAgedAccountHolderNameUpperCase = listAccountDetail.stream()
				.filter(accountDetail -> accountDetail.getAccountStatus().equalsIgnoreCase("Open"))
				.filter(accountDetail -> accountDetail.getAccountAge() > 10)
				.map(accountDetail -> accountDetail.getAccountHolderFullName().toUpperCase())
				.collect(Collectors.toList());
		
		//openAgedAccountHolderNameUpperCase.forEach(list -> System.out.println(list));
		
		System.out.println("**********");
		
		List<AccountDetail> agedAccountDetailParallel = listAccountDetail.parallelStream()
				.filter(accountDetail -> accountDetail.getAccountAge() > 10)
				.sorted(Comparator.comparing(AccountDetail::getAccountAge))
				.collect(Collectors.toList());		
						
		agedAccountDetailParallel.forEach(System.out::println);
		
		System.out.println("**********");
		
		List<String> flatMapOpenAccountNameSortedList = listAccountDetail.stream()
				.map(accountDetail -> accountDetail.getAccountName())
				.flatMap(accountName -> accountName.stream())
				.sorted(Comparator.comparing(String::toString))
				.peek(System.out::println)
				.collect(Collectors.toList());
		
		System.out.println("**********");
		
		List<List<String>> abilitiesIronMan = personMap.entrySet().stream()
				.filter(person -> person.getKey().equalsIgnoreCase("Iron Man"))
				.map(person -> person.getValue())
				.peek(System.out::println)
				.collect(Collectors.toList());
		
		System.out.println("**********");
		
	}

}
