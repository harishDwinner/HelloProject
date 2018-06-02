package GateExamples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example2 {
	public static void main(String[] args) {
		
		List<Integer> al=new ArrayList<Integer>();
		al.add(2);
		al.add(5);
		al.add(4);
		al.add(8);
		al.add(6);
		
		Iterator<Integer> info = al.iterator();
		while(info.hasNext())
		{
			System.out.println(info.next());
		}
		
		al.add(3, 555);
		Iterator<Integer> data = al.iterator();
		   
		System.out.println("----------------------");
		while(data.hasNext())
		{
			System.out.println(data.next());
		}
		System.out.println("**************************");
		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i));
		}
		
	}

}
