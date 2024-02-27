import java.util.Scanner;
import java.util.Date;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Account account = new Account(1122, 20000);
        account.setAnnualInterestRate(4.5);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println("Balance: $" + account.getBalance());
        System.out.println("Monthly Interest: $" + account.getMonthlyInterest());
        System.out.println("Date Created: " + account.getDateCreated());
    }
 private class Test {
        private int id;

        public void m1() {
            this.id = 45;
        }

        public void m2() {
            this.id = 45;
        }
    }


    public static class Account {
        private int id;
        private double balance;
        private double annualInterestRate;
        private Date dateCreated;

        public Account() {
            this(0, 0.0);
        }

        public Account(int id, double balance) {
            this.id = id;
            this.balance = balance;
            this.annualInterestRate = 0.0;
            this.dateCreated = new Date();
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public double getAnnualInterestRate() {
            return annualInterestRate;
        }

        public void setAnnualInterestRate(double annualInterestRate) {
            this.annualInterestRate = annualInterestRate;
        }

        public Date getDateCreated() {
            return dateCreated;
        }

        public double getMonthlyInterestRate() {
            return annualInterestRate / 12 / 100;
        }

        public double getMonthlyInterest() {
            return balance * getMonthlyInterestRate();
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            } else {
                System.out.println("Invalid withdrawal amount.");
            }
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }
    }


    }