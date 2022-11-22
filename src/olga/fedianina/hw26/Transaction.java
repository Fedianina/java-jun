package olga.fedianina.hw26;

public class Transaction implements Runnable {
    private Account src; // с какого аккаунта осуществлять перевод
    private Account dst; // на какой аккаунт осуществлять перевод
    private int money; // сколько переводить

    public Transaction(Account src, Account dst, int money) {
        this.src = src;
        this.dst = dst;
        this.money = money;
    }

    @Override
    public void run() {
            synchronized (src) {
                System.out.println("Застолбили аккаунт");
                if (src.getBalance()>=money) {
                    src.setBalance(src.getBalance() - money);
                }
                else {
                    System.out.println("Деньга нету");
                    return;
                }
            }
            synchronized (dst) {
                System.out.println("Застолбили аккаунт");
                dst.setBalance(dst.getBalance() + money);

            }
        }
        // TODO перевод денежных средств со счета src на счет dst в количестве money
}
