/** 
 * Project 6
 * 
 * Use Quicksort or Mergesort (your choice) to sort words of a paragraph from a file
 * into lexicographical order, and then by word length, from the longest words to the smallest.
 * You may use the implementation given in the book for Mergesort and/or Quicksort.
 * 
 * Write the output of the program to files Lexicographical.txt and LongestToShortest.txt.
 * Submit the text files, along with this modified driver program, your Quicksort or Mergesort program,
 * and the StringLengthComparitor.
 * 
 * Besides this WordSortDemo driver file to get you started, included in this week's content are
 * * StringLengthComparator.java -- the comparator from page 364 of the textbook
 * * IOExample.java -- an example program showing how read from and write to files Java 
 * * SortExample.java -- an example program demonstrating the use of comparators, including the above
 * * FarewellToArms.txt -- 	a text file of Earnest Hemmingway's masterpiece opening to the book.
 *     						(These are the words you will be sorting in the project.)
 *     
 *     Note: lexicographical natural ordering puts capital letters in front of any lower case letters. That's fine
 *     Note: Punctionation marks will be stuck to some of the words. That's fine.
 */

package src.Projects.SortWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

public class WordSortDemo {
	
	public static void main(String[] args) {

		// Hint: see IOExample for how to read in a file in. You'll want every word to go into an array.
		// Hint, so you don't have to worry about capacity,
		// you may read the words into an ArrayList first, then make an array from that.
		
		Comparator<String> byLexigraphical = Comparator.naturalOrder();
		StringLengthComparator byWordLength = new StringLengthComparator();

		ArrayList<String> data = readFile("FarewellToArms.txt");

        quickSort(data, byLexigraphical);

        writeFile("FarewellOutByLexigraphical.txt", data);

        quickSort(data, byWordLength);

        writeFile("FarewellOutByWordLength.txt", data);


		
		System.out.println("<end>");
	}

    /**
     * Reads strings in from a file and stores each word in an array list that is returned
     * @param filePath The string filepath to the file that will be read
     * @return a string array list filled with every word in the file split along the space character
     */
	private static ArrayList<String> readFile(String filePath){
        // file and stores it in a ArrayList
        File file = new File(filePath);
        String retString = "";
        ArrayList<String> words = new ArrayList<String>();
        if (file.exists()) {
            try {
                Scanner scan = new Scanner(file);
                scan.useDelimiter(" ");
                while (scan.hasNext()) {
                    retString = scan.next();
                    words.add(retString); // this adds the string into the ArrayList
                }
                scan.close();
            } catch (FileNotFoundException ignored) {
                return null;
            }
        } else
            System.out.println("Error File Not Found");
        return words;
	}

    /**
     * Writes the contents of an array list to a file with a newline after each element in the list
     * @param filePath The filepath to be written to
     * @param wordArray A string array list filled with words to be written to the file
     */
	private static void writeFile(String filePath, ArrayList<String> wordArray){
        try {

            PrintWriter outputFile = new PrintWriter(new FileWriter(filePath));

            for (String word : wordArray) {
                outputFile.println(word);
            }

            outputFile.close();
        } catch (IOException exc) {
            System.out.println("There was a problem opening the output file.");
        }


    }

    /**
     * Implementation of a quickSort to sort the array list based on the comparator
     * @param data The string array list to be sorted
     * @param comparator the comparator to be used in comparing the string values
     */
	private static void quickSort(ArrayList<String> data, Comparator comparator){
		int size = data.size();
		if (size < 2)
			return;
		String pivot = data.get(size-1);
		ArrayList<String> L = new ArrayList<>();
		ArrayList<String> E = new ArrayList<>();
		ArrayList<String> G = new ArrayList<>();

		for (String s : data){
			int c = comparator.compare(s, pivot);
			if (c < 0)
				L.add(s);
			else if (c == 0)
				E.add(s);
			else
				G.add(s);

		}

		data.removeAll(data); // so it gets emptied out and when new things are added it isn't on top of other things

		quickSort(L, comparator);
		quickSort(G, comparator);

		data.addAll(L);
		data.addAll(E);
		data.addAll(G);

        L.removeAll(L);
        E.removeAll(E); // so it gets emptied out and when new things are added it isn't on top of other things
        G.removeAll(G);
	}


}


