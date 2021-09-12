public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount test = new BankAccount();

        test.depositMoney("Checking", 10);
        test.depositMoney("Savings", 20);
        System.out.println(test.getCheckingBalance());
        System.out.println(test.getSavingsBalance());
        test.withdrawlMoney("Checking", 5);
        test.withdrawlMoney("Savings", 30);
        System.out.println(test.getCheckingBalance());
        System.out.println(test.getSavingsBalance());
        System.out.println(test.getTotal());
    }
}