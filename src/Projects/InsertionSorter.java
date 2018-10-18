package src.Projects;

import java.util.Arrays;
import java.util.Random;

/**
 * @author  Elliott Pryor
 * Created on: October 15, 2018
 */
public class InsertionSorter {

    int[] array; //the array to be modified

    /**
     * Creates and fills an array of given size with random int values 0 to 99
     *
     * @param size The size of the array
     */
    public InsertionSorter(int size) {
        fillRandomly(size);
    }

    /**
     * @param arr The int array this class will modify
     */
    public InsertionSorter(int[] arr) {
        array = arr;
    }

    /**
     * Sorts the int array of this class either in ascending or descending order
     *
     * @param ascending Sort in ascending order if true, sort in descending order if false
     */
    public void insertionSort(boolean ascending) {
        for (int i = 1; i < array.length; i++) {
            int curr = array[i];
            int j = i;
            while (j > 0 && (ascending ? array[j - 1] > curr : array[j - 1] < curr)) {  //does array[j-1] > curr if ascending = true
                                                                                        //does array[j-1] < curr if ascending = false
                array[j] = array[j - 1];
                j--;
            }
            array[j] = curr;
        }
    }

    /**
     * Prints the contents of the array
     */
    public void printArr() {
        System.out.println(Arrays.toString(array));
    }

    /**
     * Randomly re-arranges the indices of the array
     */
    public void scramble() {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int randomSpot = rand.nextInt(array.length);
            array[i] = array[randomSpot];
            array[randomSpot] = temp;
        }
    }

    /**
     * Fills an array an array with random ints 0 to 99
     *
     * @param size The size of the array to generate
     */
    private void fillRandomly(int size) {
        array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(100);
        }
    }
}
