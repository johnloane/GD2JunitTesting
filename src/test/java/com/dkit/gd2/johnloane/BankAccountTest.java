package com.dkit.gd2.johnloane;

import org.junit.*;

import static org.junit.Assert.*;

public class BankAccountTest
{
    private BankAccount account;

    @BeforeClass
    public static void beforeClass()
    {
        System.out.println("This happens before any test cases");
    }

    @Before
    public void setup()
    {
        account = new BankAccount("John", "Loane", 100, 500, "083-7755661", BankAccount.CHECKING);
        System.out.println("Setting up....");
    }

    @Test
    public void deposit()
    {
        double actualBalance = account.deposit(200, true);
        assertEquals(700, actualBalance, 0.0);
    }

    @Test
    public void withdraw_branch()
    {
        double balance = account.withdraw(600, true);
        assertEquals(-100, balance, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdraw_ATM()
    {
        account.withdraw(600, false);
    }

    @Test
    public void isChecking_true()
    {
        assertTrue(account.isChecking());
    }

    @Test
    public void isChecking_false()
    {
        BankAccount account2 = new BankAccount("John", "Loane", 100, 500, "083-7755661", BankAccount.SAVING);
        assertFalse(account2.isChecking());
    }

    @AfterClass
    public static void afterClass()
    {
        System.out.println("This happens after any test cases");
    }

    @After
    public void teardown()
    {
        System.out.println("This happens after each test");
    }
}