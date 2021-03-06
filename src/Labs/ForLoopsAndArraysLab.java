package Labs;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ForLoopsAndArraysLab {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		boolean valid = true;
		int size = 0;
		String input = "";
		
		do {
			System.out.println("Enter Size: ");
			input = scan.nextLine();
			try {
				size = Integer.parseInt(input);
				if(size > 0) {
					valid = true;
				} else {
					valid = false;
				}
			} catch (NumberFormatException e) {
				valid = false;
			}
		}while(!valid);
		
		String[] array = new String[size];
		
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter element number: " + (i+1));
			input = scan.nextLine();
			array[i] = input;
			
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
	}

}
