/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javabank;

public class Account {
    private String name;
    private int balance;

    public Account(String name, int balance) {
        this.name = name;
        setBalance(balance);
    }

    /*
     * deposit() and withdraw() are purposely implemented to show us
     * some of the problems that can arise in multithreading.
     */
    public synchronized void deposit(int amount) {
        int balance = getBalance();   // get balance and save it locally
        Rand.sleepRand(100, 200);
        setBalance(balance + amount); // make the deposit
    }

    public synchronized void withdraw(int amount) {
        int balance = getBalance();   // get balance and save it locally
        Rand.sleepRand(100, 200);
        setBalance(balance - amount); // make the withdrawal
    }

    /*
     * transfer amount from "this" account to "dest" account.
     * locks both accounts to prevent race conditions.
     */
    public void transferTo(Account dest, int amount) {
        // lock "this", then lock "dest".
        // this will deadlock now, but we'll fix that soon.
        synchronized (this) {
            synchronized (dest) {
                // withdraw from "this", transfer to "dest"
                this.withdraw(amount);  // "this." is implicit, but added for clarity
                dest.deposit(amount);
            }
        }
    }

    public String getName() {
        return name;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void setBalance(int balance) {
        this.balance = balance;
    }
}