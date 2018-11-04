package src.Labs.Interface;

import java.util.Scanner;

public class ShapeDemo {
    public static void main(String[] args){
        Polygon[] polygons = new Polygon[3];
        Square s = new Square(readDouble("Side Length of the square"));
        System.out.println("Perimeter of square: " + s.perimeter());
        System.out.println("Area of square: " + s.area());
        polygons[0] = s;

        Rectangle r = new Rectangle(readDouble("Length of one side"), readDouble("Length of a side perpendicular to side 1"));
        System.out.println("Perimeter of rectangle: " + r.perimeter());
        System.out.println("Area of rectangle: " + r.area());
        polygons[1] = r;

        Hexagon h = new Hexagon(readDouble("Side Length of the hexagon"));
        System.out.println("Perimeter of hexagon: " + h.perimeter());
        System.out.println("Area of hexagon: " + h.area());
        polygons[2] = h;


        for(Polygon p : polygons){
            System.out.println("Area of shape: " + p.area());
            System.out.println("Perimeter of shape: " + p.perimeter());

        }

    }

    private static double readDouble() {
        boolean valid = false;

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        double in = 0;
        while(!valid) {
            try {
                in = Double.parseDouble(input);
                valid = true;
            } catch (NumberFormatException e) {

            }
        }
        return in;
    }

    private static double readDouble(String text) {
        System.out.println(text);
        return readDouble();
    }
}
