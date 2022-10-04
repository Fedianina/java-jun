package hw5;
import java.util.Arrays;
public class Task2 {
    public static void main(String[] args) {

        int count = 2;
        int size = 0;
        while (count <= 20) {
            if (count % 2 == 0) size++;

            ++count;
        }
        System.out.println("a = "+ size);
        int[] arr = new int[size];
        for (count = 0; count < size; count++) arr[count] = (count + 1) * 2;
        for (count = size-1; 0<=count; count--) System.out.print(arr[count] + " ");

    }
}

