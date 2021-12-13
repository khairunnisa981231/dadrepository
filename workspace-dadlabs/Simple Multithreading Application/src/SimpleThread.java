
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;


class TimeGenerator extends Thread
{
	public void run()
	{
		//execute 10 times
		for(int i=1; i<=10; i++)
		{
			//print current thread name
			System.out.println(Thread.currentThread().getName());
			
			//get current time and setup its format
			LocalTime hour = ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.SECONDS);
			System.out.println(hour);
			
			try {
				//put a time gap between execution
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			System.out.println();
		}
		
		System.out.println("Complete 10 Executions");
	}
}


public class SimpleThread
{
	public static void main(String[] args)
	{
		
		TimeGenerator obj = new TimeGenerator();
		
		//start thread
		obj.start();
	}

}
