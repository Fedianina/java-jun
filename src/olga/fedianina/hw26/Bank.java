package olga.fedianina.hw26;

public class Bank {

    public void transferMoney(Account src, Account dst, int money){
        Thread transaction = new Thread(new Transaction(src, dst, money));
        transaction.start();
        System.out.println("Погнали");
    }
}