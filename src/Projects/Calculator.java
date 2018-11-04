package src.Projects;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){

        boolean run = true;
        double number = readDouble("Please enter a number: ");//gets the initial input
        while (run){
            System.out.println("Total is now: " + number);//prints out current value
            String op = readOp(); //reads what operation to do
            switch (op) {
                case "+":
                    number += readDouble();                                     //adds the second number to total
                    break;
                case "-":
                    number -= readDouble();                                     //subtracts second number from total
                    break;
                case "*":
                    number *= readDouble();                                     //Multiplies second number by first number
                    break;
                case "/":
                    double in = 0;
                    do{
                        in = readDouble("Please enter a non-zero number"); //Reads the input

                    }while (in == 0);                                           //Loops until input is non-zero

                    number /= in;                                               //Divides total by second number
                    break;
                case "=":
                    run = false;                                                //Exits the loop
                    break;
            }
        }

        System.out.println("Total is now: " + number); //prints the total

    }

    /**
     * Reads a mathematical operator from the user
     * @return A string only containing + - * / or =
     */
    private static String readOp(){
        boolean valid = false;

        Scanner scan = new Scanner(System.in);
        String input;
        String in = "";

        System.out.println("Please enter an operator ( + - * / )");
        System.out.println("Or enter \" = \" to end the program");

        while(!valid) {
            input = scan.nextLine();
            if(input.equals("+") || input.equals("-") || input.equals("*") ||input.equals("/") || input.equals("=")){ //ensures that input is only one of the operators
                valid = true;
                in = input;
            } else {
                System.out.println("Please enter a valid operator ( + - * / or =");
            }
        }
        scan.close();
        return in;
    }

    /**
     * Reads a double input from the user and verifies that it is a double
     * @param text The text to print out in case of invalid input
     * @return Guarantees a double
     */
    private static double readDouble(String text) {
        boolean valid = false;

        Scanner scan = new Scanner(System.in);
        String input;
        double in = 0;
        System.out.println("Please enter a number:");
        while(!valid) {
            input = scan.nextLine();
            try {
                in = Double.parseDouble(input);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println(text);
            }
        }
        scan.close();
        return in;
    }

    /**
     * Reads a double input from the user and verifies that it is a double
     * @return Guarantees a double
     */
    private static double readDouble() {

        return readDouble("Please enter an actual number");
    }



}
