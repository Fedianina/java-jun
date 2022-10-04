package lesson5;
import java.util.Arrays;
public class FifthLessons {
    public static void main(String[] args) {

        int  [] arr = new int [] {1, 23, 4, 5, 27, 8, 17};
        int size = arr.length;
        //System.out.println(size);
        //for (int i = 0; i< 10; ++i) System.out.println(arr[(int)(size  * Math.random())]);



        //for (int element : arr) System.out.println(element);
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        int i = Arrays.binarySearch(arr, 8);
        //System.out.println(i);
        int [] newArr = new int[] {100, 200, 300, 400, 500};
        System.arraycopy(arr, 1, newArr, 2, 2);
        System.out.println(Arrays.toString(newArr));

    }
}
