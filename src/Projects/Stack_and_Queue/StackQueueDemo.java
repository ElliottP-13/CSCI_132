package src.Projects.Stack_and_Queue;

/**
 * Project 04
 * 
 * 1. Implement Stack and Queue interfaces using DoublyLinkedList (provided) 
 * to create and demo the Stack and Queue ADTs
 * 
 * a. Create a class DLLStack to implement the Stack interface,
 * b. Create a class DLLQueue to implement the Queue interface.
 * 
 * 
 * 2. Implement Stack interface using Array (you create)
 *  to create and demo the Stack ADT
 * 
 * a. Create a class ArrayStack (capacity of 10) to implement the Stack interface
 * !! HINT: See the book, page 230 -- it shows how to do this. You may use it. Type, don't paste.
 * 
 * 
 * Provided: Stack.java (interface), Queue.java (interface), DoubleLinkedList.java (class)
 * Deliverables: DLLStack.java, DLLQueue.java, ArrayStack.java
 * 
 * 3. Using your new ATDs, develop a method to test whether a string is a palindrome.
 * A palindrome is a word or phrase that is spelled the same backwards as forwards,
 * ie: "level" or "race car" or "a man a plan a canal panama"
 * 
 * Use the StackQueueDemo driver class to demo your ATDs. You should push and pop elements from the Stacks,
 * enque and deque elements from the Queue, demo the size and isEmpty methods for all. 
 * Test a real palindrome, and a fail.
 * 
 *
 */
public class StackQueueDemo {	

	public static void main(String[] args) {
		
		// test doubly linked list stack
		DLLStack<String> dllTestStack = new DLLStack<>();
		
		dllTestStack.push("one");
		dllTestStack.push("two");
		dllTestStack.push("three");
		dllTestStack.push("four");
		dllTestStack.push("five");
		
		System.out.println(dllTestStack.toString());
		
		dllTestStack.pop();
		dllTestStack.pop();
		System.out.println(dllTestStack.toString());
		
		System.out.println(testPalindrom("taco cat"));//real palindrome
		System.out.println(testPalindrom("hot dog"));//not palindrome
		System.out.println(testPalindrom("a man a plan a canal panama"));//real palindrome

		
		// test array stack
		ArrayStack<Double> arrayTestStack = new ArrayStack<>();
		
		arrayTestStack.push(10.1);
		arrayTestStack.push(12.2);
		arrayTestStack.push(14.4);
		arrayTestStack.push(16.6);
		arrayTestStack.push(18.8);
		
		System.out.println(arrayTestStack.toString());
		
		arrayTestStack.pop();
		arrayTestStack.pop();
		System.out.println(arrayTestStack.toString());
		
		
		// test doubly linked list queue
		DLLQueue<Integer> dllTestQueue = new DLLQueue<>();
		
		dllTestQueue.enqueue(10);
		dllTestQueue.enqueue(20);
		dllTestQueue.enqueue(30);
		dllTestQueue.enqueue(40);
		dllTestQueue.enqueue(50);
		
		System.out.println(dllTestQueue.toString());
		
		dllTestQueue.dequeue();
		dllTestQueue.dequeue();
		System.out.println(dllTestQueue.toString());
		
				
	}

	private static boolean testPalindrom(String str){
		DLLStack<Character> stack = new DLLStack<>();
		str = str.replaceAll(" ", "");

		for (int i = 0; i < str.length(); i++){
			stack.push(str.charAt(i));
		}
		String reverse = "";
		while (stack.size() > 0){//stack.size() will decriment with the pop()
			reverse += stack.pop();
		}
		return reverse.equals(str);

	}

}
