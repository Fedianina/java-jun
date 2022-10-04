package hw2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        int month = 7;
        if (month > 13 && month <0) {
            System.out.println("Неверный диапазон");
        }
        else{
            if (month % 12 < 3)
                System.out.println("Зима");
            else if (month % 12 < 6)
                System.out.println("Весна");
            else if (month % 12 < 9)
                System.out.println("Лето");
            else
                System.out.println("Осень");
        }
    }
}
