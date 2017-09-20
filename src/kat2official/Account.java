package kat2official;

public class Account {

    private int pin;
    private int account_number;
    private int balance;

    public Account(int a, int b, int c) {

        this.pin = a;
        this.account_number = b;
        this.balance = c;
    }

    public int validate(int number) {
        if (number == this.pin) {
            return account_number;
        } else {
            return -1;
        }
    }

    public String deposit(int amount) {



        if (amount > 0) {
            balance = balance + amount;
            return "Epityxhs synallagh";
        } else {
            return "Apotyxia synallaghs den ginete arnitiki katathesi";
        }

    }

    public String withdraw(int amount) {

        if (balance >= amount && amount > 0) {
            balance = balance - amount;
            return "Epityxhs synallagh";
        } else {
            return "Apotyxia synallaghs den eparkei to ypolipo sas ";
        }
    }

    public int update() {
        return balance;
    }

    public static void close(){


    }
}
