package src.Labs;

import Assets.Helper;

import java.util.Arrays;


/**
 * Lab 08
 * 
 * Modify the gieven recursive binary search algorithm so that it returns the index of the target
 * in the sequence or -1 (if the target is not found).
 * 
 * Create a static instance variable called searches to track the number of times binarySearch is called
 * 
 * In the main method, prompt the user for an array size n, and fill an array with random values between 1 and n.
 * you may use java.util methods Arrays.sort and Arrays.toString to sort and print the array
 * 
 * Use your modified search to test the number of searches required to find the target. 
 * 
 * Try the same test with different input sizes for n. 
 * What is the running time of binarySearch? 
 * Give your answer in a print statement at the end of the program in big-O notation.
 * 
 *
 */

public class BinarySearch {


	  /**
	   * Returns true if the target value is found in the indicated portion of the data array.
	   * This search only considers the array portion from data[low] to data[high] inclusive.
	   */
	  static int calls = 0;
	  public static int binarySearch(int[] data, int target, int low, int high) {
	  	calls ++;
	    if (low > high || high > data.length || low < 0)
	      return -1;                                           // interval empty; no match
	    else {
	      int mid = (low + high) / 2;
	      if (target == data[mid])
	        return mid;                                          // found a match
	      else if (target < data[mid])
	        return binarySearch(data, target, low, mid - 1);      // recur left of the middle
	      else
	        return binarySearch(data, target, mid + 1, high);     // recur right of the middle
	    }
	  }
	
	/** You may use the method main here to test and demo the lab... */
	public static void main(String[] args) {
		Helper h = new Helper();
		int size = h.readInt("Please enter the size of an array");
		int[] array = h.fillRandomly(size);
		Arrays.sort(array);
		binarySearch(array, array[h.rand(0, array.length-1)], array[0], array[array.length-1]);
		System.out.println("It took " + calls + " tries to find the solution");

		for (int i = 0; i < 3; i++) {
			calls = 0;
			array = h.fillRandomly((int)Math.pow(10, i+1));
			Arrays.sort(array);
			binarySearch(array, array[h.rand(0, array.length-1)], array[0], array[array.length-1]);
			System.out.println("It took " + calls + " tries to find the solution of array with len " + array.length);
		}

        System.out.println("This function is Logarithmic");

	}

}
