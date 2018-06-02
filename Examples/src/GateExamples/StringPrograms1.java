package GateExamples;

import java.util.Set;
import java.util.TreeSet;

public class StringPrograms1 {
	
	public static void main(String[] args) {
		
		String data="ramakrishna";
		
		char []str=data.toCharArray();
		Set<Character>li= new TreeSet<Character>();	
		
		
		for(int i=0;i<str.length;i++)
		{
			for(int j=i+1;j<str.length;j++)
			{
				
				if(str[i]==str[j])
				{
					li.add(str[i]);
				}
			}
		}
		
		for (Character character : li) 
		{
			System.out.println(character + " is repeated....!");
		}
	}

}
