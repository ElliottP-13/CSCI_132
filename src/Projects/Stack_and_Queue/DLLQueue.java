package src.Projects.Stack_and_Queue;

public class DLLQueue<E> implements Queue<E> {

    private DoublyLinkedList<E> self;
    public DLLQueue (){
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
    public void enqueue(E e) {
        self.addLast(e);
    }

    @Override
    public E first() {
        return self.first();
    }

    @Override
    public E dequeue() {
        return self.removeFirst();
    }

    public String toString() {
        return self.toString();
    }
}
