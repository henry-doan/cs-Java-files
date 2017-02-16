package assignment04;

/**
 * Compute pi by summing up terms of this infinite summation with using the fraction class
 *
 * @author  Henry Doan
 * @version February 15th, 2017
 */
public class Computation {

	/**  
	 * Application entry point.  This is where  
	 * execution starts. This calls another method
	 * and then use summation to get pi.  
	 *  
	 * @param args (not used)  
	 */
	public static void main(String[] args) {
		// initial starter for the increment
		int i = 0;
		
		// holds the value of the answer
		Double summationResult = (double) 0;

		// one way to stop before over flow but still reaches infinity or near the answer but not with precision
		while ( summationResult != Math.PI) {
			// does the summation in terms with i
			summationResult = summationResult + fractionCompute( i ).toDouble();
			
			// increment i
			i++;
		}
		
		// print out the answer
		System.out.println("Pi is about: " + summationResult + " for this program. until..");

	}
	
	/**  
	 *  A Method that has all of the math as fractions to be calculated for each increment
	 *  of I.
	 *  
	 * @param int i a number to manipulate the item by the incremented number from 0 to infinity
	 * @return insideAndOutsideMultiplied Fraction, the result of the inside the parathesis times the outside of the parathesis to get the calculation for summation.
	 */
	public static Fraction fractionCompute( int i) {
		// having the fractions in terms of i
		Fraction outsideTheParathesisCompute = new Fraction (1, (long) (Math.pow(16, i)));
		Fraction firstComputeFraction = new Fraction (4, (8 * i + 1));
		Fraction secondComputeFraction = new Fraction (2, (8 * i + 4));
		Fraction thirdComputeFraction = new Fraction (1, (8 * i + 5));
		Fraction forthComputeFraction = new Fraction (1, (8 * i + 6));
		
		// the calculations for the inside the parathesis.
		Fraction firstAndSecondCompute = firstComputeFraction.subtract(secondComputeFraction);
		Fraction secondAndThirdCompute = firstAndSecondCompute.subtract(thirdComputeFraction);
		Fraction insideTheParathesisCompute = secondAndThirdCompute.subtract(forthComputeFraction);
		
		// answer the outside the parathesis times the inside.
		Fraction insideAndOutsideMultiplied = outsideTheParathesisCompute.multiply(insideTheParathesisCompute);

		// return the answer
		return insideAndOutsideMultiplied;
	}

}
