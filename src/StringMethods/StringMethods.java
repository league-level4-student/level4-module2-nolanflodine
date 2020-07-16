package StringMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if(s1.length()>s2.length()) {
		return s1;
		}
		else {
			return s2;
		}
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
		String s2 = s;
		if(s.contains("underscores")) {
			s2 = "";
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i)==' ') {
					s2 = s2+'_';
				}
				else {
					s2 = s2+s.charAt(i);
				}
			}
		}
		return s2;
	}

	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		s1 = s1.trim();
		s2 = s2.trim();
		s3 = s3.trim();
		char[] c = new char[3];
		for (int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i)==' ') {
				c[0] = s1.charAt(i+1);
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			if(s2.charAt(i)==' ') {
				c[1] = s2.charAt(i+1);
			}
		}
		for (int i = 0; i < s3.length(); i++) {
			if(s3.charAt(i)==' ') {
				c[2] = s3.charAt(i+1);
			}
		}
		if(c[0]<c[1]&&c[0]<c[2]) {
			return s1;
		}
		if(c[1]<c[0]&&c[1]<c[2]) {
			return s2;
		}
		else {
			return s3;
		}
	}
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int total = 0;
		for (int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				total+=Character.getNumericValue(s.charAt(i));
			}
		}
		return total;
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		String s1 = "";
		for (int i = 0; i < s.length(); i++) {
			if(s.contains(substring)) {
			s1=s1+s-s.indexOf(substring)+substring.length(); //basically what I want to do, but need to redo it correctly
			}
			else {
				return 0;
			}
		}
		return 0;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		return null;
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		return null;
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		return 0;
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		return 0;
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		return true;
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
