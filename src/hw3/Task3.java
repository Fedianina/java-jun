package hw3;

import java.util.Scanner;
public class Task3 {
    public static void main(String[] args) {

        System.out.println( "Загадай число от 2 до 100");
        int start = 2;
        int end = 101;
        int mid = (end + start)/2;
        Scanner in = new Scanner(System.in);
        victory:
        while (true){
            System.out.println("Число =");
            System.out.println(mid);
            System.out.println("0 - Нет \n1 - Дa");
            int userNumber = in.nextInt();

            switch (userNumber){
                case 0 ->{
                    System.out.println("Загаданное число больше? 0- нет, 1 - да");
                    userNumber = in.nextInt();
                    switch (userNumber){
                        case 0 ->{
                            end = mid;
                            mid = (end + start)/2;
                        }
                        case 1 ->{
                            start = mid;
                            mid = (end + start)/2;
                        }
                    }
                }
                    case 1 -> {
                        System.out.println("Ура");
                        break victory;
                    }
            }
        }
    }
}
