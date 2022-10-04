package hw2;

public class Task2 {
    public static void main(String[] args) {
        double sum = 1000, price;
        int saleCode = 9011;

        switch (saleCode){
            case 4525:
                price = sum * 0.7;
                System.out.println(price);
                break;

            case 6424:
            case 7012:
                price = sum * 0.8;
                System.out.println(price);
                break;

            case 7647:
            case 9011:
            case 6612:
                price = sum * 0.9;
                System.out.println(price);
                break;

            default:
                price = sum;
                System.out.println(price);
        }
    }
}
