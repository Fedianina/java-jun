package hw5;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {

        String string = "в предложении все слова разной длины";
        String arr[] = string.split(" ");
        int size = arr.length;
        int max = arr[0].length();
        int index = 0;
        for (int count = 1; count < size; ++count) {
            if (max < arr[count].length()) {
                max = arr[count].length();
                index = count;
            }
        }
        System.out.println("Самое длинное слово " + arr[index]);
    }
}
