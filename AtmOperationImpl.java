package com.atm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AtmOperationImpl implements AtmOperationInterf{
    ATM atm=new ATM();
    List<String> statement_list = new ArrayList<>();
    @Override
    public void viewBalance() {
        System.out.println("Available Balance is : "+atm.getBalance());

    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if (withdrawAmount % 500 == 0) {
            if (withdrawAmount <= atm.getBalance()) {
                statement_list.add(withdrawAmount + " Withdrawn");
                System.out.println("Collect the Cash " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance !!");
            }
        } else {
            System.out.println("Please enter the amount in multiples of 500");
        }
    }


    @Override
    public void depositAmount(double depositAmount) {
        statement_list.add(depositAmount + " Amount Deposited");
        System.out.println(depositAmount + " Deposited Successfully !!");
        atm.setBalance(atm.getBalance() + depositAmount);
        viewBalance();
    }


    @Override
    public void viewMiniStatement() {
        for (String activity : statement_list) {
            System.out.println(activity);
        }

    }
}