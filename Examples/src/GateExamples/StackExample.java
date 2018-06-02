package GateExamples;

import java.util.Stack;

public class StackExample {
	
	public static void main(String[] args) {
		
		Stack<Integer>st=new Stack<Integer>();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		st.push(60);
		
		int totalSize=st.size();
				
		for(int i=totalSize-1;i>=0;i--)
		{
			
			System.out.println(st.get(i));
			System.out.println("-----");
		}
		
		st.pop();
		
		totalSize=st.size();
		for(int i=totalSize-1;i>=0;i--)
		{  
			
			System.out.println(st.get(i));
			System.out.println("-----");
		}
		
			
	}

}
