package com.sango.java8.defaultmethod;

public interface JustAnyInterface {
	public void doSomething();
	public default void doThisByDefault() {
		System.out.println("This is from first default method"); 		
	}
	
	public default void doThisByDefault2() {
		System.out.println("This is from second default method");		
	}
}
