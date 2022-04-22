package CommonLibraries;

import java.util.Random;

/**
 * This class contain generic method related to java
 * 
 * */
public class JavaLibrary 
{
	/**
	 * this method will generate a random number for every execution
	 * 
	 * */
	public int getRandomNumber()
	{
		Random ran = new Random();
		return ran.nextInt(1000);
	}
}
