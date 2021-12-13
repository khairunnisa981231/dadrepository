
public class MultipleThread
{
	public static void main(String[] args)
	{
		Runnable array = new ArrayText();
		Thread printResult = new Thread(array);
		
		printResult.start();
	}

}
