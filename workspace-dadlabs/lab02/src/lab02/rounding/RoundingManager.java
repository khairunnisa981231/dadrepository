package lab02.rounding;

/**
* This class contains method to manage the rounding of values.
*
* @author emalianakasmuri
*/

import java.text.DecimalFormat;

public class RoundingManager
{
	/**
	 * This method calculates percentage from dividend and divisor
	 * 
	 * @param dividend
	 * @param divisor
	 * @return value in percentage
	 */
	public double calculatePercentage(int dividend, int divisor) 
	{
		// Parsing the parameter values to double
		double percentage = ((double) dividend / (double) divisor) * 100;
		return percentage;
	}

	/**
	 * This method rounds the value to the requested decimal points
	 * 
	 * @param value
	 * @param decimalPoints
	 * @return result in specific decimal point
	 */
	
	public String roundValue(double value, int decimalPoints) 
	{
		// Generate decimal points
		String decimalPlaces = ".";
		for (int counter = 0; counter < decimalPoints; counter++)
			decimalPlaces += "0";
		
		// Generate empty string if requires no decimal points
		if (decimalPoints == 0)
			decimalPlaces = "";
		
		// Round the value into the specified decimal points
		DecimalFormat formatter = new DecimalFormat("###" + decimalPlaces);
		String result = formatter.format(value);
		return result;
	}
}
