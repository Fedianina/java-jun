package olga.fedianina.lesson10;

import java.util.Arrays;

public class Figure {
    private final Point[] points;

    public Figure(int pointsCounter) {
        if (pointsCounter < 2) {
            throw new IllegalArgumentException("Фигура " + " должна состоять из 2 и более точек");
        }
        this.points = new Point[pointsCounter];
    }

    public Point[] getPoints() {
        return points;
    }

    public void addPoint(Point point) {
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                points[i] = point;
                System.out.println("Точка " + point + " была добавлена");
                return;// чтобы точка не перезаписалась
            }
        }
        System.out.println("Точка " + point + " не была добавлена" + "У фигуры достаточно точек.");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Figure)) return false;
        Figure figure = (Figure) object;
        return Arrays.equals(points, figure.points);
    }

    @Override
    public String toString() {
        return "Figure{" +
                "points=" + Arrays.toString(points) +
                '}';
    }

    @Override
    public Figure clone() {
        Figure clone = new Figure(points.length);
        for (int i = 0; i < points.length; i++) {
            clone.points[i] = points[i].clone();
        }
            return clone;

        }
    }

