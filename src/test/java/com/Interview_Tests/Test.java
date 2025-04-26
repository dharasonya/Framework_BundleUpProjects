package com.Interview_Tests;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String s = "Gtes";

	        // Count for special characters
	        int count = 0;

	        // Iterating through the string to 
	        // check for special characters
	        for (int i = 0; i < s.length(); i++) {
	            // If character is not a letter, digit, or space, 
	            // it's a special character
	            if (!Character.isLetterOrDigit(s.charAt(i)) 
	                && !Character.isWhitespace(s.charAt(i))) {
	                count++; // Increment count for special characters
	            }
	        }

	        // Displaying the result
	        if (count > 0) {
	            System.out.println("Special characters found: " + count);
	        } else {
	            System.out.println("No Special Characters found.");
	        }
	    }
	}


