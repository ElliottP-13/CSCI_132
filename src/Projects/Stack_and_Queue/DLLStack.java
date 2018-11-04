package src.Projects.Stack_and_Queue;

public class DLLStack <E> implements Stack<E>{
    private DoublyLinkedList<E> self;
    public DLLStack (){
        self = new DoublyLinkedList<>();
    }

    @Override
    public int size() {
        return self.size();
    }

    @Override
    public boolean isEmpty() {
        return self.isEmpty();
    }

    @Override
    public void push(E e) {
        self.addFirst(e);
    }

    @Override
    public E top() {
        return self.first();//It errors if I don't have self even though it is a DoublyLinkedList it says that it is an Object instead of E
    }

    @Override
    public E pop() {
        return self.removeFirst();
    }

    public String toString() {
        return self.toString();
    }
}
