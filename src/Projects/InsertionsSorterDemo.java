package src.Projects;

import java.util.Scanner;

/**
 * @author Elliott Pryor
 * Created on: October 15, 2018
 */
public class InsertionsSorterDemo {
    public static void main(String[] args) {
        InsertionSorter sorter = new InsertionSorter(readInt("Enter size of the array"));//makes a random array with ints 0-99 of the given size

        String input = "";
        sorter.printArr();

        while (!input.equals("quit") && !input.equals("4")) {//Quits looping if quit or 4 are entered
            input = readString("1. Sort Ascending\n" +
                    "2. Sort Descending\n" +
                    "3. Shuffle\n" +
                    "4. Quit").toLowerCase();//gathers input and makes it lower case to ensure it enters the if statements
            if (input.equals("sort ascending") || input.equals("ascending") || input.equals("1"))//sort ascending
                sorter.insertionSort(true);
            else if (input.equals("sort descending") || input.equals("descending") || input.equals("2"))//sort descending
                sorter.insertionSort(false);
            else if (input.equals("shuffle") || input.equals("3"))//scramble
                sorter.scramble();

            sorter.printArr();//print the new array with things done to it.
        }


    }

    /**
     * Guarantees an int value. Will continue looping if not given an integer value
     *
     * @param text The text printed to the console as a prompt
     * @return an int value scanned in from the console
     */
    public static int readInt(String text) {

        System.out.println(text);

        boolean valid = false;

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int in = 0;
        while (!valid) {
            try {
                in = Integer.parseInt(input);
                valid = true;
            } catch (NumberFormatException e) {

            }
        }
        return in;
    }

    /**
     * Prompts a user with text and returns the input from the console as a string
     *
     * @param text the text printed to the console as a prompt
     * @return a string value scanned in from the console
     */
    public static String readString(String text) {
        Scanner scan = new Scanner(System.in);
        System.out.println(text);
        return scan.nextLine();
    }

}
