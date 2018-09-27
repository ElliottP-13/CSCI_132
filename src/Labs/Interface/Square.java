package src.Labs.Interface;

import java.util.Scanner;

public class Square implements Polygon {
    private double side_length;
    /**
     *
     * @param side The length of side of the square
     */
    public Square(double side){
        side_length = side;
    }

    @Override
    public double area() {
        return Math.pow(side_length, 2);
    }

    @Override
    public double perimeter() {
        return side_length * 4;
    }


}
