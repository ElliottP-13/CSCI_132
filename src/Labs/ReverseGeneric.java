package src.Labs;

import java.util.Arrays;

public class ReverseGeneric {
    public static void main(String[] args) {
        String[] s = new String[]{"A", "B", "C", "D", "E"};
        Integer[] i = new Integer[]{1, 2, 3, 4, 5, 6};
        Song[] songs = new Song[5];
        for(int x= 0; x < songs.length; x++){
            songs[x] = new Song("Song " + x, "Artist " + x);
        }
        reverseArray(s);
        reverseArray(i);
        reverseArray(songs);
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(i));
        System.out.println(Arrays.toString(songs));

    }

    public static <E> void reverseArray(E[] array){
        int low = 0, high = array.length - 1;
        while (low < high) {
            E temp = array[low];
            array[low++] = array[high];    // post-increment of low
            array[high--] = temp;        // post-decrement of high
        }
    }

}
