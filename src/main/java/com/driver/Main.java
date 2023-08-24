package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        CurrentAccount currentAccount=new CurrentAccount("Ram",10000,"1024");
        currentAccount.generateAccountNumber(1234,10);
        currentAccount.deposit(2000);
        currentAccount.withdraw(12000);
        currentAccount.validateLicenseId();
    }
}