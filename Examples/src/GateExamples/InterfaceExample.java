package GateExamples;

interface student
{
	public void name();
	public void age();
	public void dept();
	
}

class College implements student
{

	@Override
	public void name() {
		// TODO Auto-generated method stub
		System.out.println("Sashi");
	}

	@Override
	public void age() {
		// TODO Auto-generated method stub
		
		System.out.println("age");
	}

	@Override
	public void dept() {
		// TODO Auto-generated method stub
		System.out.println("CSE");
	}
	
}


class InterfaceExample
{
	public static void main(String[] args) 
	{
		student c = new College();
		c.name();
		c.age();
		c.dept();
	}
}
