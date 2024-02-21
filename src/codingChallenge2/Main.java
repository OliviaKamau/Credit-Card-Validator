//OLIVIA KAMAU - CODING CHALLENGE 2 - MCC COMP SCI CLUB
package codingChallenge2;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		long ccNumber = 0;
		Scanner scan = new Scanner(System.in);
		boolean validInput = false;
		
		while(!validInput) {
			try {
				System.out.print("Number: ");
				ccNumber = scan.nextLong();
				validInput = true;						//Exits loop.
		
			} catch (InputMismatchException e) {		//Catches invalid input.
				scan.next();							//Prompts user to re-enter value if they enter an invalid number.
			}
		}
		
		boolean Valid = ccValidDeterminer(ccNumber);		//Calls ccValidDeterminer to output the type of card
		
		if(Valid) {
			String ccType = ccTypeDeterminer(ccNumber);		//Calls ccTypeDeterminer method if card no. is valid
			System.out.println(ccType);
		} else {
			System.out.println("INVALID");
		}

	}		
		
	//Method to determine the type of card the user has
	public static String ccTypeDeterminer(long ccNumber) {

		String ccNumberString = Long.toString(ccNumber);
		int ccNumberLength = ccNumberString.length();
		
		if(ccNumberLength == 16) {
			
			//MasterCard conditions
			if(ccNumberString.startsWith("51") || ccNumberString.startsWith("52")|| ccNumberString.startsWith("53") || ccNumberString.startsWith("54") || ccNumberString.startsWith("55")) {
				System.out.println("MASTERCARD");	
			}
			
			//Visa conditions
			else if(ccNumberString.startsWith("4")) {
				System.out.println("VISA");
			}
			else {
				System.out.println("INVALID");
			}
		}
		
		else if(ccNumberLength == 15) {
			
			//American Express conditions
			if(ccNumberString.startsWith("34")|| ccNumberString.startsWith("37")) {	
				System.out.println("AMERICAN EXPRESS");
			} else {
				System.out.println("INVALID");
			}
		}
		
		else {
			System.out.print("INVALID");
		}
		
		return " ";
}

	//Method to determine whether the card no. entered is valid.
	public static boolean ccValidDeterminer(long ccNumber) {
	
		String ccNumberString = Long.toString(ccNumber);
		int sum = 0;
	
		//Multiplies every other digit by 2, adds it to the sum.
		for (int i = ccNumberString.length()-2; i >= 0; i-=2) {						
			sum += sumDigits(Character.getNumericValue(ccNumberString.charAt(i)) * 2);
		}
	
		//Adds remaining digits that weren't multiplied to the sum.
		for (int i = ccNumberString.length()-1; i>=0; i-=2) {
			sum += Character.getNumericValue(ccNumberString.charAt(i));
		}
	
		return (sum % 10 == 0);				//Checks whether calculated no. is divisible by 10/ends with 0.
	
	}

	//Adds the single-digit numbers together
	public static int sumDigits(int num) {
	
		if (num <10) {
			return num;
		}
		return num % 10 + num/10;
	}


}



/***********     OUTPUT          *********
 * 
 * 			Test Case 1:
 * 
 * 	Number: 4003600000000014
	VISA
 * 
 *   
 *   		Test Case 2:
 *   
 * 	Number: Olivia
	Number: HAHAHAHAH
	Number: 4003600000000014
	VISA
 * 
 * 		
 * 
 * 			Test Case 3:
 * 
 * 	Number: 4003-6000-0000-0014
	Number: 4003600000000014
	VISA
	
	
 */
