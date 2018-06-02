package GateExamples;

public class ThrowExample
{
	
	public static void voterCheck(int age)
	{
		if(age<18)
		{
			throw new ArithmeticException("Cannot Vote");
		}
		else
		{
			System.out.println("Can vote");
		}
		
	}

	
	public static void main(String[] args) 
	{
		try 
		{
			voterCheck(15);
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}
