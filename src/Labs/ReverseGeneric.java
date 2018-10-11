package src.Labs;

public class ReverseGeneric<E> {
    private E[] array;
    public ReverseGeneric(E[] arr){
        array = arr;

        for (E x : arr){
            System.out.println("Element: " + x.toString());
        }
    }

    public static <E> void reverseArray(E[] array){
        int low = 0, high = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            E temp = array[low];
            array[low++] = array[high];    // post-increment of low
            array[high--] = temp;        // post-decrement of high
        }
    }
}
