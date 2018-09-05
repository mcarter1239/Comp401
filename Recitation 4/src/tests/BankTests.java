package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bank.BankAccount;

class BankTests {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void constructorTest() {
		BankAccount myAccount = new BankAccount();
		
		assertEquals(0.0, myAccount.currentBalance());
		assertFalse(myAccount.isPinActive());
		
	}
	
	@Test
	void depositMoneyTest() {
		BankAccount myAccount = new BankAccount();
		myAccount.depositMoney(500.0);
		assertEquals(500.0, myAccount.currentBalance());
	}
	@Test
	void withdrawMoneyTest() {
		BankAccount myAccount = new BankAccount();
		myAccount.depositMoney(500.0);
		myAccount.withdrawMoney(250.0);
		assertEquals(250.0, myAccount.currentBalance(), 0.0001);
	}
	@Test
	void withdrawMoreThanYouHaveTest() {
		BankAccount myAccount = new BankAccount();
		myAccount.depositMoney(500.0);
		assertFalse(myAccount.withdrawMoney(1000.0));
		assertEquals(500.0, myAccount.currentBalance(), 0.001);
		
	}
	@Test
	void depositNegativeMoneyTest() {
		BankAccount myAccount = new BankAccount();
		assertFalse(myAccount.depositMoney(-500.0));
		assertEquals(0.0, myAccount.currentBalance());
	}
	@Test
	void setPinTest() {
		BankAccount myAccount = new BankAccount();
		assertTrue(myAccount.setPin("aaaa"));
	}
	
}
