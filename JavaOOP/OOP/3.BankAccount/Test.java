public class Test {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(50, 50);
        BankAccount account2 = new BankAccount(100, 80);
        BankAccount account3 = new BankAccount();
        BankAccount account4 = new BankAccount();

        account1.deposit("saving", 70);
        account2.deposit("saving", 150);
        account2.withdraw("checking", 40);

        System.out.println("number of accounts is " + BankAccount.getNumberOfAccounts());

        System.out.println("\naccount 1 info:");
        System.out.println("checking balance = " + account1.getCheckingBalance());
        System.out.println("saving balance = " + account1.getSavingBalance());
        System.out.println("total account money = " + account1.getTotalAccountMoney());
        System.out.println("account number is " + account1.getAccountNumber());

        System.out.println("\naccount 2 info:");
        System.out.println("checking balance = " + account2.getCheckingBalance());
        System.out.println("saving balance = " + account2.getSavingBalance());
        System.out.println("total account money = " + account2.getTotalAccountMoney());
        System.out.println("account number is " + account2.getAccountNumber());
    }
}