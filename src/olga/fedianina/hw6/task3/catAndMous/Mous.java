package olga.fedianina.hw6.task3.catAndMous;

public class Mous {
    private double speed;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        if (speed < 10) throw new IllegalArgumentException("Скорость должна быть не меннее 10");

        this.speed = speed;
    }

    public Mous(double speed) {
        setSpeed(speed);
    }

    public Mous() {
        setSpeed(30 * Math.random() + 11);
    }
}
