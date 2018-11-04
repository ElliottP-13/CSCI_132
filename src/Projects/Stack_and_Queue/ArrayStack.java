package src.Projects.Stack_and_Queue;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E>
{

    private E[] self;
    private int index;

    public ArrayStack(){
        this(10);
    }

    public ArrayStack(int size){
        index = 0;
        if(size > 0)
            self = (E[]) new Object[size];
        else
            self = (E[]) new Object[10];
    }

    @Override
    public int size() {
        return self.length;
    }


    @Override
    public boolean isEmpty() {
        for (E e : self){
            if (e != null)
                return false;
        }
        return true;
    }

    @Override
    public void push(E e){
        if(index < self.length) {
            self[index] = e;
            index++;
        }
    }

    @Override
    public E pop(){
        E temp = self[index];
        self[index] = null;
        if(index > 0)
            index--;
        return temp;
    }

    @Override
    public E top(){
        return self[index];
    }

    public String toString() {
        return Arrays.toString(self);
    }


}
