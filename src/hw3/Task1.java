package hw3;

import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество тарелок");
        int plate = in.nextInt();
        System.out.println("Введите количество моющего средства");
        double detergent = in.nextDouble();

        while (0 < plate && 0.5 <= detergent){
            detergent -=0.5;
            plate -=1;
            System.out.println("Тарелок осталось");
            System.out.println(plate);
            System.out.println("Средства осталось" );
            System.out.println(detergent);
        }
    }
}
