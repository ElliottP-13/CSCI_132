package src.Labs;

import java.util.Random;
import java.util.Timer;

public class PrefixAverages {

	public static double[] prefixAverage1 (double[] x) {
		int n = x.length;
		double[] a = new double[n];
		for (int j = 0; j < n; j++) {
			double total = 0;
			for (int i = 0; i <= j; i++)
				total += x[i];
			a[j] = total / (j + 1);

		}
		return a;
	}
	
	public static double[] prefixAverage2(double[] x) {
		int n = x.length;
		double[] a = new double[n];
		double total = 0;
		for (int j = 0; j < n; j++) {
			total += x[j];
			a[j] = total / (j + 1);
		}
		return a;
	}

	private static double[] fillRandomly(int size) {
		double[] array = new double[size];
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = rand.nextInt(100);
		}
		return array;
	}

	public static void main(String[] args) {

	    int length = 5;

	    long[] avg1 = new long[length];
	    long[] avg2 = new long[length];


        for(int i = 1; i < length + 1; i++){
            double[] arr = fillRandomly((int)(scale(i - 1)));
            avg1[i-1] = runPrefix1(arr);
            avg2[i-1] = runPrefix2(arr);
        }

        for (int i = 0; i < avg1.length; i++) {
            System.out.println("n = " + scale(i) + " alg 1 time: " + avg1[i]);
        }

        double total = 0;
        for (int i = 0; i < avg1.length -1; i++) {
            double deltay = avg1[i + 1] - avg1[i];
            double deltax = scale(i + 1) - scale(i);

            System.out.println("Delta: " + deltay/deltax);
        }

        for (int i = 0; i < avg2.length; i++) {
            System.out.println("n = " + scale(i) + " alg 2 time: " + avg2[i]);

        }

        for (int i = 0; i < avg2.length -1; i++) {
            double deltay = avg2[i + 1] - avg2[i];
            double deltax = scale(i + 1) - scale(i);

            System.out.println("Delta: " + deltay/deltax);
        }


        System.out.println("These results indicate the Big O of first algorithm is quadratic, and second algorithm is linear.");

	}

	private static double scale(int i){
		return i^2;
	}

	private static long runPrefix1(double[] array){
	    long startTime = System.nanoTime();
	    prefixAverage1(array);
	    return System.nanoTime() - startTime;
    }
    private static long runPrefix2(double[] array){
        long startTime = System.nanoTime();
        prefixAverage2(array);
        return System.nanoTime() - startTime;
    }

}
