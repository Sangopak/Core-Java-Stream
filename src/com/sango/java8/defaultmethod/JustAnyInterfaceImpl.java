package com.sango.java8.defaultmethod;

public class JustAnyInterfaceImpl implements JustAnyInterface {

	@Override
	public void doSomething() {
		System.out.println("This is from the Implementation class from DoSomething");
	}
	
	@Override
	public void doThisByDefault() {
		System.out.println("This is from the Implementation class from doThisByDefault");
	}

}
 