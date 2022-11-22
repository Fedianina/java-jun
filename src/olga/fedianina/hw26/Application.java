package olga.fedianina.hw26;

public class Application {
    public static void main(String[] args) {


        Account account = new Account(32, 3500);
        Account account1 = new Account(33, 2800);
        Bank bank = new Bank();

        bank.transferMoney(account, account1,  1500);

        System.out.println(account.getId() + " " + account.getBalance());
        System.out.println(account1.getId() + " " + account1.getBalance());
        System.out.println(account.getId() + " " + account.getBalance());

    }
}
