package olga.fedianina.hw11;

public enum Planets {
    //EARTH, VENUS, MARS;

    PLANET1 ("Венера",6051.8, 4.8675),
    PLANET2("Земля", 6356.8, 5.9726),
    PLANET3("Марс", 3376.2, 6.4171);

    private String name;
    private double radius;
    private double weight;




    Planets(String name, double radius, double weight) {
        this.name = name;
        this.radius = radius;
        this.weight = weight;
    }


    public String getName() {
        return name;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius<3376.2)
            throw new IllegalArgumentException("Рфдиус не должен быть меньше 3376.2");
        this.radius = radius;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight<4.8675)
            throw new IllegalArgumentException("Вес не должен быть меньше 4.8675");
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Planets{" +
                "name='" + name + '\'' +
                ", radius=" + radius +
                ", weight=" + weight +
                '}';
    }
}
