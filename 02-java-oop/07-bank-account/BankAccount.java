public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;

    private static int numberOfAccounts = 0;
    private static double totalAmount = 0;

    public BankAccount() {
        numberOfAccounts++;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void depositMoney(String accountParam, double amount) {
        if (accountParam.equals("Checking")) {
            checkingBalance += amount;
            totalAmount += amount;
        }
        if (accountParam.equals("Savings")) {
            savingsBalance += amount;
            totalAmount += amount;
        }
    }

    public void withdrawlMoney(String accountParam, double amount) {
        if (accountParam.equals("Checking")) {
            if (amount <= checkingBalance) {
                checkingBalance -= amount;
                totalAmount -= amount;
            } else {
                System.out.println("Insufficient funds");
            }
        }
        if (accountParam.equals("Savings")) {
            if (amount <= savingsBalance) {
                savingsBalance -= amount;
                totalAmount -= amount;
            } else {
                System.out.println("Insufficient funds");
            }
        }
    }

    public double getTotal() {
        return totalAmount;
    }
}