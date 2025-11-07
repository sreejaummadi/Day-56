package com.codegnan.cards;

import java.util.ArrayList;
import java.util.Collections;

import com.codegnan.Exceptions.InSufficientBalanceException;
import com.codegnan.Exceptions.InsufficientMachineBalanceException;
import com.codegnan.Exceptions.InvalidAmountException;
import com.codegnan.Exceptions.NotAOperatorException;
import com.codegnan.interfaces.IATMService;

public class AxisDebitCard implements IATMService {
	String name;
	long debitcardnumber;
	double accountBalance;
	int pinnumber;
	ArrayList<String>statement;
	final String type="user";
	int chances;

	public AxisDebitCard(String name, long debitcardnumber, double accountBalance, int pinnumber) {
		chances=3;
		this.name = name;
		this.debitcardnumber = debitcardnumber;
		this.accountBalance = accountBalance;
		this.pinnumber = pinnumber;
		statement=new ArrayList<>();
	}

	@Override
	public String getUserType() throws NotAOperatorException {
		return type;
	}

	@Override
	public double withdrawAmount(double withDrawAmount)
			throws InvalidAmountException, InSufficientBalanceException, InsufficientMachineBalanceException {
		if(withDrawAmount<=0) {
			throw new InvalidAmountException("You enter Zero amount to withdraw please enter a valid amount");
		}else {
			if(withDrawAmount%100!=0) {
				throw new InvalidAmountException("Please with draw Multiples of 100");
			}else {
				if(withDrawAmount>accountBalance) {
					throw new InSufficientBalanceException("You can not withdraw more than amount of your account balance");
				}else {
					accountBalance-=withDrawAmount;
					statement.add("Debited: "+withDrawAmount);
					return withDrawAmount;
				}
			}
		}
		//return withDrawAmount;
	}

	@Override
	public void depositAmount(double dptAmount) throws InvalidAmountException {
		if(dptAmount<=0 ||dptAmount%100!=0 ) {
			throw new InvalidAmountException("You Can't deposit less than Zero rupess and deposit multiples of 100 ");
		}else {
			accountBalance+=dptAmount;
			statement.add("Credited: "+dptAmount);
		}
		
	}
	@Override
	public double checkAccountBalance() {
		return accountBalance;
	}
	@Override
	public void changePinNumber(int pinNumber) {
		this.pinnumber=pinNumber;
	}
	@Override
	public int getPinNumber() {
		return pinnumber;
	}
	@Override
	public String getUserName() {
		return name;
	}
	@Override
	public void decreaseChances() {
		--chances;
		
	}
	@Override
	public int getChances() {
		return chances;
	}
	@Override
	public void resertPinChances() {
		chances=3;	
	}
	@Override
	public void generateMiniStatement() {
		int count=5;
		if(statement.size()==0) {
			System.out.println("There are No Transactions Happened");
			return;
		}
		System.out.println("======================List 5 Transaction==========");
		//to get statements in recent order
		for(String trans:statement) {
			if(count==0) {
				break;
			}
			System.out.println(trans);
			count--;
		}
		Collections.reverse(statement);
	}

}
