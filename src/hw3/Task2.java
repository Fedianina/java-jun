package hw3;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        double a = Math.random();
        int d = (int)((10-1)*a +1);
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("Введи свое число");
            int userNumber = in.nextInt();
            if (userNumber < d && userNumber!=0){
                System.out.println("загаданное число больше");
            }
            else if (d< userNumber){
                System.out.println("загаданное число меньше");
            }
            else if(userNumber == d){
                System.out.println("Вы угадали");
                break;
            }
            if(userNumber == 0){
                System.out.println("выход");
                break;
            }
        }
    }
}
