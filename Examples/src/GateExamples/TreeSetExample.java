package GateExamples;

import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		
		TreeSet<Integer> ts=new TreeSet<>();
		ts.add(50);
		ts.add(40);
		ts.add(500);
		ts.add(23);
		ts.add(19);
		System.out.println(ts);
		ts.pollFirst();
		System.out.println(ts);
		ts.pollLast();
		System.out.println(ts);
		
		
		
	}
}
