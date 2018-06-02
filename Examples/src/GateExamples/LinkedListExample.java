package GateExamples;

import java.util.LinkedList;

public class LinkedListExample {

	public static void main(String[] args) {
		
		 LinkedList<Integer> ll= new LinkedList<Integer>();
		 ll.add(10);
		 ll.add(1, 20);
		 ll.add(2, 30);
		 ll.addFirst(999);
		 ll.addLast(1000);
		 
		
		
		 
		int height=ll.size();
		
		System.out.println(height);
		System.out.println(ll);
		
		 for(int i=0;i<height;i++)
		 {
			 ll.poll();
			 System.out.println(ll);
			 if(ll.isEmpty())
			 {
				 System.out.println("no elements left out");
			 }
		 }
		 
		// System.out.println(ll);
		 
	}
}
