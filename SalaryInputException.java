package stream_lab_03_03_2025;

@SuppressWarnings("serial")
public class SalaryInputException extends Exception
{
	public SalaryInputException()
	{
		
	}
	
	public SalaryInputException(String errorMessage)
	{
		super(errorMessage);
	}

}
