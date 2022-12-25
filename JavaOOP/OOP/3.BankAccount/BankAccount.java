import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingBalance;
    private static int numberOfAccounts;
    private double totalAccountMoney; // required to be static in assignment, but this way it'll be same for all accounts
    private String accountNumber; // required to be static in assignment, but this way it'll be same for all accounts

    // constructor
    public BankAccount() {
        this(0, 0);
        accountNumber = generateAccountNumber();
    }
    public BankAccount(double checkingInitial, double savingInitial) {
        this.checkingBalance = checkingInitial;
        this.savingBalance = savingInitial;
        this.totalAccountMoney = checkingInitial + savingInitial;
        accountNumber = generateAccountNumber();
        numberOfAccounts++;
    }

    // getters
    public double getCheckingBalance() {
        return this.checkingBalance;
    }
    public double getSavingBalance() {
        return this.savingBalance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }
    public double getTotalAccountMoney() {
        return totalAccountMoney;
    }

    // methods
    public void deposit(String account, double amount) {
        if(account.equals("saving")) {
            this.savingBalance += amount;
        }
        else if(account.equals("checking")) {
            this.checkingBalance += amount;
        }
        totalAccountMoney += amount;
    }
    public void withdraw(String account, double amount) {
        if(account.equals("saving") && this.savingBalance > 0) {
            this.savingBalance -= amount;
            totalAccountMoney -= amount;
        }
        else if(account.equals("checking") && this.checkingBalance > 0) {
            this.checkingBalance -= amount;
            totalAccountMoney -= amount;
        }
    }
    private String generateAccountNumber() {
        char[] nums = "0123456789".toCharArray();
        Random r = new Random();
        String accNum = "";
        for(int i=0; i<10; i++) {
            int randomNumber = r.nextInt(10);
            accNum += nums[randomNumber];
        }
        return accNum;
    }
}