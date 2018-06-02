package GateExamples;

import java.util.HashSet;

public class SetsExample1 {

	public static void main(String[] args)
	{
		
		HashSet<String>hs =new HashSet<String>();
		hs.add("Alpha");
		hs.add("Beta");
		hs.add("Alpha");
		hs.add("Gamma");
		hs.add("Epsilon");
		hs.add("Pi");
		hs.add("Orion");
		hs.add("Alpha");
		
		hs.remove("Beta");
		
		System.out.println(hs);
		
	}
}
