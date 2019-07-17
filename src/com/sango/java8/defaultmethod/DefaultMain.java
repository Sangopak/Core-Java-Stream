package com.sango.java8.defaultmethod;

public class DefaultMain {
	public static void main(String[] args) {
		JustAnyInterfaceImpl justAnyInterfaceImpl = 
				new JustAnyInterfaceImpl();
		justAnyInterfaceImpl.doSomething();
		System.out.println("***********");
		justAnyInterfaceImpl.doThisByDefault();
		System.out.println("***********");
		justAnyInterfaceImpl.doThisByDefault2();
		System.out.println("***********");
	}
}
