package olga.fedianina.hw11;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Planets.values()));


        Planets mars = Planets.PLANET3;
        mars.setRadius(3953903);
        System.out.println(Arrays.toString(Planets.values()));

    }
}
