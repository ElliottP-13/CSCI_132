package src.Labs.Interface;

public class Hexagon implements Polygon{
    private double side_length;
    private final double area_coefficient = 3 * Math.sqrt(3) / 2; // is the constant coefficient in the area of a hexagon equation
    public Hexagon(double side){
        side_length = side;
    }

    @Override
    public double area() {
        return area_coefficient * Math.pow(side_length, 2);
    }

    @Override
    public double perimeter() {
        return 6 * side_length;
    }
}
