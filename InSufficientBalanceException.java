package com.codegnan.Exceptions;

public class InSufficientBalanceException extends Exception{
	public InSufficientBalanceException(String errormsg) {
		super(errormsg);
	}
}
