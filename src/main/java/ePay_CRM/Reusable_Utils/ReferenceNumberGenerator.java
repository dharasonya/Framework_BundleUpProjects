package ePay_CRM.Reusable_Utils;

import java.util.Random;

public class ReferenceNumberGenerator {
	 public String generateReferenceNumber() {
	        String prefix = "TEST";
	        Random random = new Random();

	        // Generate a random number with 6 digits (to make the total length 10 including "TEST")
	        int randomNumber = random.nextInt(10000); // Generates a number between 0 and 999999

	        // Format the random number with leading zeros to ensure 6 digits
	        String formattedNumber = String.format("%08d", randomNumber);

	        // Combine prefix and formatted number
	        return prefix + formattedNumber;
	    }
	 /* public static void main(String[] args) {
	        // Example usage
	        String referenceNumber = generateReferenceNumber();
	        System.out.println("Generated Reference Number: " + referenceNumber);
	    }*/
}

