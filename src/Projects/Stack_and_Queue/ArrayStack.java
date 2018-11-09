package src.Projects.Stack_and_Queue;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E>
{

    private E[] self;
    private int index;

    /**
     * Creates a stack with an array as a container
     * Defaults to an array size of 10
     */
    public ArrayStack(){
        this(10);
    }

    /**
     * Creates a stack with an array as a container
     * @param size The size of the array as a container. If size is negative it constructs an array of size 10
     */
    public ArrayStack(int size){
        index = 0;
        if(size > 0)
            self = (E[]) new Object[size];
        else
            self = (E[]) new Object[10];
    }

    /**
     * @return The number of non-null elements within the array
     */
    @Override
    public int size() {
        int i;
        for (i = 0; i < self.length; i++) {
            if (self[i] == null)
                break;
        }
        return i + 1;
    }


    /**
     *
     * @return boolean value that returns false if there are any non-null elements in the stack, and returns true if every
     * element is null
     */
    @Override
    public boolean isEmpty() {
        for (E e : self){
            if (e != null)
                return false;
        }
        return true;
    }

    /**
     * Adds an element to the stack
     * @param e  Element to be added to the top of the stack
     */
    @Override
    public void push(E e){
        if(index < self.length) {
            self[index] = e;
            index++;
        }
    }

    /**
     * Removes the first element in the stack from the list and returns it
     * @return The element at the top of the stack
     */
    @Override
    public E pop(){
        E temp = self[index];
        self[index] = null;
        if(index > 0)
            index--;
        return temp;
    }

    /**
     * Returns the value of the element at the top of the stack but does not remove it from the stack
     * @return The element at the top of the stack
     */
    @Override
    public E top(){
        return self[index];
    }

    /**
     * @return A string representation of the data within the queue
     */
    public String toString() {
        return Arrays.toString(self);
    }


}
