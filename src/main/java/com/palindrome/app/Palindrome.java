package com.palindrome.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;

/**
 * 
 * Class containing logic determining is provided text palindrome.
 * 
 * @author Alina Goncarko
 *
 */
public class Palindrome {

	/**
	 * Main method that runs from command line
	 * 
	 * @param args
	 *            - no command line args needed
	 */
	public static void main(String[] args) {
		System.out.println("\n* Launching Palindrome app...");
		Application.launch(JavaFXPalindromeApp.class, args);
	}

	/**
	 * Checks is provided String empty
	 * 
	 * @param pText
	 *            - text for checking
	 * @return true if text is empty
	 */
	public static boolean isTextEmpty(String pText) {
		if (pText == null) {
			return true;
		}

		// removes all whitespaces and non-visible
		// characters (e.g., tab, \n).
		if (pText.replaceAll("\\s", "").isEmpty()) {
			return true;
		}

		return false;
	}

	/**
	 * Checks if text contains characters only
	 * 
	 * @param pText
	 *            - text for checking
	 * @return true if text is valid
	 */
	public static boolean isTextValid(String pText) {
		if (isTextEmpty(pText)) {
			return false;
		}

		// removes all whitespaces and non-visible
		// characters (e.g., tab, \n).
		String text = pText.replaceAll("\\s", "");

		// checks that string contains only characters
		// and punctuation symbols, starts with a character
		// not case sensitive
		Pattern pattern = Pattern.compile("[a-z][a-z!.,\\-:;?()\"]*", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(text);
		if (matcher.matches()) {
			return true;
		}

		return false;
	}

	/**
	 * Check is text a polindrome, i.e. is it possible to read it from both
	 * sides.
	 * 
	 * @param pText
	 *            - text to check is it a polindrome
	 * @return true if text is a polindrome
	 */
	public static boolean isTextPalindrome(String pText) {
		if (!isTextValid(pText)) {
			return false;
		}

		// removes everything except letters, converts to lowercase
		String text = pText.replaceAll("\\s", "").replaceAll("[!.,\\-:;?()\"]", "").toLowerCase();

		//algorithm comparing letters from sides to the middle
		//of the phrase
		int left = 0;
		int right = text.length() - 1;
		while (left < right) {
			if (text.charAt(left++) != text.charAt(right--)) {
				return false;
			}
		}

		return true;
	}

}
