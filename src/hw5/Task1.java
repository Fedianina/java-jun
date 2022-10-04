package hw5;
import java.util.Arrays;
import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = in.nextInt();
        int[] arr1 = new int[size];
        int summ = 0;
        for (int i = 0; i < size; ++i) {
            arr1[i] = (int) ((100 - 1) * Math.random());
            summ+= arr1[i];
            for (int j = 0; j < i; ++j) {
                if (arr1[i] == arr1[j]) --i;
            }
        }
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        int min = arr1 [0];
        int max = arr1[size-1];
        System.out.println("Минимальное значение = " + min);
        System.out.println("Максимальное значение =" + max);
        System.out.println("Среднее арифметическое = " + (double)summ/size);

    }
}
