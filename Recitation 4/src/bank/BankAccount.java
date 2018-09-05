//Name:				
//Onyen:			
//Recitation Code:	

package bank;

public class BankAccount {
	
	double myBalance;
	boolean isPinActive;
	String myPin;

	// You cannot have a negative balance
	// You cannot deposit or withdraw negative money
	// If you try to withdraw more than you have, it fails
	// A pin is set to off by default
	// Users can set an optional 4 letter pin, and if the amount
	//   they want to withdraw is over 500 dollars, they
	//   must enter that pin
	// You are able to change your pin
	// Each method will return true if it succeeds and false if it
	//   fails

	public BankAccount() {
		myBalance = 0;
		isPinActive = false;
	}

	// this method returns your current balance
	public double currentBalance() {
		return myBalance;
	}

	// this method deposits money into the bank account
	public boolean depositMoney(double moneyToAdd) {
		if(moneyToAdd > 0) {
			myBalance = moneyToAdd;
			return true;
		}
		return false;
	}

	// this method withdraws money from your account
	public boolean withdrawMoney(double moneyToWithdraw) {
		if(moneyToWithdraw <= currentBalance()) {
			if(moneyToWithdraw < 500.0) {
				myBalance = myBalance - moneyToWithdraw;
				return true;
			}
		}
		return false;
	}
	
	
	// these following methods use a pin
	// this method turns on your pin
	public boolean setPin(String myPin) {
		this.myPin = myPin;
		return true;
	}

	// returns status of pin
	public boolean isPinActive() {
		return isPinActive;
	}

	// this method does same as deposit but requires pin
	public boolean withdrawMoney(double moneyToWithdraw, String enteredPin) {
		if (isPinActive() && enteredPin.equals(this.myPin)) {
			withdrawMoney(moneyToWithdraw);
			return true;
		} else {
			return false;
		}
		
	}
}
