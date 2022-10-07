package olga.fedianina.lessons7;

import olga.fedianina.lessons7.units.King;

public class Application {
    public static void main(String[] args) {
        King king1 = new King(200);
        king1.rest();

        King king2 = new King(200);
        king1.rest(king1);

        System.out.println(king1.getHealthScore());
    }
}
