package GateExamples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example1 {
	
	public static void main(String[] args)
	{
		List<String> al=new ArrayList<String>();
		al.add("A");
		al.add("B");
		al.add("C");
		
		System.out.println(al);
		
		al.add(3,"E");
		System.out.println(al+"-----------"+al.size());
		
		al.remove(2); 
		System.out.println(al);
		
		Iterator<String>data=al.iterator();
		
		while(data.hasNext())
		{
			System.out.println(data.next());
		}
	}

}
