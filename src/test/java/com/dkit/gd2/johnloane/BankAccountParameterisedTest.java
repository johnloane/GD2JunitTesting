package com.dkit.gd2.johnloane;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountParameterisedTest
{
    private BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountParameterisedTest(double amount, boolean branch, double expected)
    {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @Before
    public void setup()
    {
        account = new BankAccount("John", "Loane", 123, 1000, "083-3335555", BankAccount.CHECKING);
        System.out.println("Setup before test....");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions()
    {
        return Arrays.asList(new Object[][]{
                {100.00, true, 1100},
                {200.00, true, 1200},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000.00, true, 2000},

        });
    }

    @Test
    public void deposit()
    {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), 0.00001);
    }

}
