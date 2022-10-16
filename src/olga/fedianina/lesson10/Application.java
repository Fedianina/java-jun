package olga.fedianina.lesson10;

public class Application {
    public static void main(String[] args) {

    Point a = new Point(23, -12);
    Point b = new Point(23, -12);


    System.out.println(a);
    System.out.println(b);
    System.out.println(a==b);//false
    System.out.println(a.equals(b));//false
    Point aClone = a.clone();


    Figure figure = new Figure(2);
    figure.addPoint(a);
    figure.addPoint(b);
    System.out.println(figure);
    }
}
