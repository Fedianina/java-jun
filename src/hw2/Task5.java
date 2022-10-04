package hw2;

public class Task5 {
    public static void main(String[] args) {

        int age = 11, exp = 120;
        if (age>100) {
            System.out.println("Мы Вам перезвоним");
        }
        else {
            if (exp < 5) {
                System.out.println("Вы подходите на должность стажера");
            } else if (5 <= exp) {
                System.out.println("Вы подходите на должность разработчика");
            }
        }
    }
}
