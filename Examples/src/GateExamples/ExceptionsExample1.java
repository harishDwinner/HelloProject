package GateExamples;

public class ExceptionsExample1 
{
	
	public static void checkVoterEligibility(int age)
	{
		if(age<18)
		{
			throw new ArithmeticException("Not Eligible");
		}
		else
		{
			System.out.println("Eigible for Vote.....!");
		}
	}
	public static void main(String[] args)
	{
		
		try
		{ 
			checkVoterEligibility(10);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
