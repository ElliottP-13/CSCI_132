package src.Projects.Stack_and_Queue;

public interface Stack<E> {
	
	int size();

	boolean isEmpty();
	
	void push(E e);
	
	E top();
	
	E pop();

}
