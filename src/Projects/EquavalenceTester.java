package src.Projects;

import java.util.ArrayList;
import java.util.Arrays;
import Projects.Dice;

public class EquavalenceTester {

	public static void main(String[] args) {
		
		// primitive variables...
		int a = 5;
		int b = 5;
		int c = a;
		
		System.out.println(a == b);		
		System.out.println(a == c);		
		c = 10;
		System.out.println(a == c);
		
		
		// reference variables..

		
		// arrays of primitives data types...
		int[] intArrayA = {5, 9, 7, 1, 8};
		int[] intArrayB = {5, 9, 7, 1, 8};
		int[] intArrayC = intArrayA;
		
		System.out.println(intArrayA == intArrayB);		
		System.out.println(intArrayA == intArrayC);		
		// intArrayC[1] = 0;
		System.out.println(intArrayA == intArrayC);		
		System.out.println();
		
		// so how do we do it then?
		System.out.println(intArrayA.equals(intArrayB));			
		System.out.println(Arrays.equals(intArrayA, intArrayB));
		
		
		// arrays of objects (reference variables)...
		String[] stringArrayA = {"five", "nine", "seven", "one", "eight"};
		String[] stringArrayB = {"five", "nine", "seven", "one", "eight"};
		String[] stringArrayC = stringArrayA;
		
		System.out.println(stringArrayA.equals(stringArrayC));			
		System.out.println(stringArrayA.equals(stringArrayB));			
		System.out.println(Arrays.equals(stringArrayA, stringArrayB));	
		
		
		// 2D Arrays
		final int ROWS = 3;
		final int COLS = 4;
		
		int[][] array2DA = new int[ROWS][COLS];
		for (int row = 1; row < ROWS; row++) 
			for (int col = 1; col < COLS; col++) 
				array2DA[row][col] = row * col;

		int[][] array2DB = new int[ROWS][COLS];
		for (int row = 1; row < ROWS; row++) 
			for (int col = 1; col < COLS; col++) 
				array2DB[row][col] = row * col;
		
		int[][] array2DC = array2DA;	
		
		System.out.println(array2DA == array2DC);				
		System.out.println(Arrays.equals(array2DA, array2DB));		
		System.out.println(Arrays.deepEquals(array2DA, array2DB));	
		

//		// introducing ArrayList...
//		ArrayList<Integer> myList = new ArrayList<>();
//		myList.add(1);
//		myList.add(8);
//		System.out.println(myList.toString());
//		
//		ArrayList<Integer> myList2 = new ArrayList<>();
//		myList2.add(1);
//		myList2.add(8);
//		System.out.println(myList2.toString());
//		
//		System.out.println(myList.equals(myList2));
//		
//		ArrayList<String> myListS = new ArrayList<>();
//		myListS.add("one");
//		myListS.add("two");
//		System.out.println(myListS.toString());		


		

	}

}
