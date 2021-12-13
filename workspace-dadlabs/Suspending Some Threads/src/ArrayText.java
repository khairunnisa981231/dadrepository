import java.util.Random;

public class ArrayText implements Runnable
{
	String[] arrayText = {"It", "is", "recommended", "to"
			, "user", "Calendar", "class"};
	
	//number of repetition
	int n = 10;
	
	//get the size of array
	int arraySize = arrayText.length;
	
	//new size for new array
	int final_size = arraySize*n;
	
	//new array to store the elements
	String[] final_arrayText = new String[final_size];


	//method to extract and display the array
	public void ArrayExtraction ()
	{
		String text = "";
		
		Thread currentThread = new Thread();
		String threadName = currentThread.getName();
		
		System.out.println("This section will extract array element and increase in every repetition");
		System.out.println();
		
		for (int i=0; i<n; i++)
		{
			System.out.println(threadName);
			//declare new array as the array bound is lesser then 10
			final_arrayText[i] = arrayText[i%arraySize];
			text = text + " " + final_arrayText[i];
            System.out.println(text);
		}
		
		System.out.println();
	}	
	
	
	//method to shuffle the order of array element
	public void RandomArray()
	{
		Random rand = new Random();
		
		for (int i=0 ;i<arraySize; i++)
		{
			//generate random index
			int index = rand.nextInt(arraySize);
			
			//create temporary variable
			String temp = arrayText[i];
			arrayText[i] = arrayText[index];
			arrayText[index] = temp;
		}
		
		System.out.println("This section will display array in random order");
		System.out.println();
		
		//loop array with new index
		for (int i=0; i<arraySize; i++)
		{
			//display the array
			System.out.println(arrayText[i]);
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	
	
	
	@Override
	public void run() 
	{
		//Thread to execute ArrayExtraction method
		Thread text = new Thread(new Runnable()
				{

					@Override
					public void run() 
					{
						// TODO Auto-generated method stub
						ArrayExtraction();
					}
			
				});
		
		//Thread to execute RandomArray method
		Thread word1 = new Thread(new Runnable()
				{

					@Override
					public void run() {
						// TODO Auto-generated method stub
						RandomArray();
					}	
			
				});
		
		text.start();
		word1.start();
	}
	

}