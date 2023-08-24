package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.maxWithdrawalLimit=maxWithdrawalLimit;
        this.rate=rate;
    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        try{
            if(amount>maxWithdrawalLimit){
                throw new Exception("Maximum Withdraw Limit Exceed");
            }
            if(super.getBalance()<amount){
                throw new Exception("Insufficient Balance");
            }
            super.setBalance(super.getBalance()-amount);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double si=(getBalance()*rate*years)/(100.0);
        return si;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double mul=times*years*1.0;
        double rbn=(rate*1.0)/times;
        rbn=1+rbn;
        rbn=Math.pow(rbn,mul);
        return getBalance()*rbn;
    }

}
