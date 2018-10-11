package src.Labs.Interface;

public class Rectangle implements Polygon {

    private double s1;
    private double s2;

    /**
     *
     * @param side1 The length of a side of the rectangle (base)
     * @param side2 The length of a side perpendicular to side1 (height)
     */
    public Rectangle(double side1, double side2){
        s1 = side1;
        s2 = side2;
    }

    @Override
    public double area() {
        return s1 * s2;
    }

    @Override
    public double perimeter() {
        return 2 * (s1 + s2);
    }
}

