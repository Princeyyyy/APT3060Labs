package com.example.apt3060labs.lab5;

public class BankAccount {
    private static BankAccount instance;
    private double balance;

    private BankAccount() {
        balance = 0;
    }

    public static synchronized BankAccount getInstance() {
        if (instance == null) {
            instance = new BankAccount();
        }
        return instance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}