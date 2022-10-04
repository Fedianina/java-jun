package hw2;

public class Task4 {
    public static void main(String[] args) {

        double c = Math.random();
        int a = (int) ((501-10) * c + 10);
        System.out.println(a);
        if (25<a && a<200)
            System.out.println("Входит");
        else
            System.out.println("Не входит");
    }
}
