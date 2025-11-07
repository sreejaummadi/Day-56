package com.codegnan.interfaces;

import com.codegnan.Exceptions.InSufficientBalanceException;
import com.codegnan.Exceptions.InsufficientMachineBalanceException;
import com.codegnan.Exceptions.InvalidAmountException;
import com.codegnan.Exceptions.NotAOperatorException;

public interface IATMService {
	//to get the user type whether the user us operator or normal user.
	public abstract String getUserType()throws NotAOperatorException;
	//to withdraw an amount
	//1.will throw invalidAmountException if the amount is not valid amount
	//2.will throw insufficientBalance exception if the customer has insufficient balance in account
	//3.will throw insufficentmachinebalanceException if the machine has insufficient cash
	public abstract double withdrawAmount(double withDrawAmount)throws InvalidAmountException,InSufficientBalanceException,InsufficientMachineBalanceException;
	//to deposit the amount
	public abstract void depositAmount(double dptAmount)throws InvalidAmountException;
	//to check your balance amount
	public abstract double checkAccountBalance();
	//to change the pin number
	public abstract void changePinNumber(int pinNumber);
	//to get pin number
	public abstract int getPinNumber();
	//to get the user name
	public abstract String getUserName();
	//to get the number of chances while user entered the wrong pin number
	public abstract void decreaseChances();
	//to get the chances of pin number
	public abstract int getChances();
	//to reset the pin number chances by bank operator
	public abstract void resertPinChances();
	//to get the mini statement of the account
	public abstract void generateMiniStatement();
}
