package src.Projects.Stack_and_Queue;

public interface Queue<E> {
	
	int size();
	
	boolean isEmpty();
	
	void enqueue(E e);
	
	E first();
	
	E dequeue();

}
