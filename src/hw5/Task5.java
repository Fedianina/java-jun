package hw5;
import java.util.Arrays;
public class Task5 {
    public static void main(String[] args) {
        //Задать массив. Отрицательные элементы массива перенести в новый массив. Размер массива должен быть равен количеству отрицательных элементов.
        int [] arr  = {-5, 8, 4, -89, 90, -34, 6, 3};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int size = arr.length;
        int count= 0;
        while (count<size && arr[count]<0){
            ++count;
        }
        int [] copyArr = new int [count];
        System.arraycopy(arr, 0, copyArr, 0, count);
        System.out.println(Arrays.toString(copyArr));

    }
}
