package Projects;


import java.util.Random;
import java.util.Scanner;

/**
 * @author Elliott Pryor
 */
public class Dice {



	/**
	 * Simulates rolling a die
	 * @return a random number 1 through 6
	 */
	public int roll() {
		return rand(1, 6); 
	}
	
	/**
	 * Prompts the user to input the number of dice rolls, then returns the average of that many rolls
	 * @return average number that was rolled on a dice
	 */
	public void avg() {
		int rolls = readInt("How many rolls would you like to average?");
		int sum = 0;
		for (int i = 0; i < rolls; i++) {
			sum += roll();
		}
		double average = ((double)(sum))/((double)rolls); //casted as a double for rounding
		System.out.println("The average for " + rolls + " number of rolls was " + average);
	}
	
	/**
	 * Returns a random number within a range (inclusive)
	 * @param start The start value of the range
	 * @param end The end value of the range
	 * @return the random number within the range
	 */
	public int rand(int start, int end) {
		Random a = new Random();
		return (a.nextInt(end) + start);
	}
	/**
	 * Accepts input from the console and verifies that the input is an integer value
	 * @return Integer value inputed into the console
	 */
	public int readInt() {
		boolean valid = false; //used in the loop to ensure an integer was inputed
		
		Scanner scan = new Scanner(System.in);//to input the int
		String input = "";//declares the variable
		int in = 0;
		do {
			input = scan.nextLine(); //reads the input as a string
			try {
				in = Integer.parseInt(input);
				valid = true;
			} catch (NumberFormatException e) {
				System.out.println("Please input a numeric integer value");
			}
		} while(!valid);//loop while it is a non-valid input
		return in;//returns the integer that was inputed
	}
	
	/**
	 * Prompts the user to input an integer value
	 * @param Text to be printed to console as a prompt
	 * @return the integer value inputed into the console
	 * This does something
	 */
	public int readInt(String txt) {
		System.out.println(txt);
		return readInt();
	}

}
