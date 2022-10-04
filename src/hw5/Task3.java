package hw5;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Scanner sizeNumber = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = sizeNumber.nextInt();
        sizeNumber.nextLine();
        Scanner newWord = new Scanner(System.in);
        String[] arr = new String[size];
        for (int count = 0; count < size; ++count) {
            System.out.println("Введите слово");
            String word = newWord.nextLine();
            if (word.equals("exit")) {
                break;
            }
            arr[count] = word;
            for (int i = 0; i < count; ++i) {
                if ((arr[i].compareTo(arr[count])) == 0) {
                    --count;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


}

