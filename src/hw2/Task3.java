package hw2;

public class Task3 {
    public static void main(String[] args) {

        int count = 1247;

        if (90<= count  && count <=100)
            System.out.println( "Отлично");
        else if (60 <= count && count <=89)
            System.out.println("Хорошо");
        else if (40 <= count && count <=59)
            System.out.println("Удовлетворительно");
        else if (0 <= count && count <=39)
            System.out.println("Попробуйте в следующий раз");
        else
            System.out.println("Некорректное число");
    }
}
