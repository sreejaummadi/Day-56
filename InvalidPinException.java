package com.codegnan.Exceptions;
public class InvalidPinException extends Exception{
	public InvalidPinException(String errormsg) {
		super(errormsg);
	}
}
