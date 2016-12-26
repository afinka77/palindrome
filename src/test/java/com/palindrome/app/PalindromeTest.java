package com.palindrome.app;

import java.util.Collections;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit tests for Palindrome class
 */
public class PalindromeTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public PalindromeTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(PalindromeTest.class);
	}

	/**
	 * Tests "isTextEmpty" method
	 */
	public void testIsTextEmpty() {
		assertTrue(Palindrome.isTextEmpty(null));
		assertTrue(Palindrome.isTextEmpty(""));
		assertTrue(Palindrome.isTextEmpty("  "));
		assertTrue(Palindrome.isTextEmpty(" \n \n \n\t "));

		assertFalse(Palindrome.isTextEmpty("a"));
		assertFalse(Palindrome.isTextEmpty("\na"));
		assertFalse(Palindrome.isTextEmpty("    a"));
	}

	/**
	 * Tests "isTextValid" method
	 */
	public void testIsTextValid() {
		
		assertTrue(Palindrome.isTextValid("a"));
		assertTrue(Palindrome.isTextValid("a b c"));
		assertTrue(Palindrome.isTextValid("\ta b c"));
		assertTrue(Palindrome.isTextValid("\tA B C"));
		assertTrue(Palindrome.isTextValid("aA!.,-:;?()"));
		assertTrue(Palindrome.isTextValid("a.b.c"));
		assertTrue(Palindrome.isTextValid("a-b-c"));
		assertTrue(Palindrome.isTextValid("a - \"bc\""));
		assertTrue(Palindrome.isTextValid("A man, a plan, a canal - Panama!"));
				
		assertFalse(Palindrome.isTextValid(null));
		assertFalse(Palindrome.isTextValid(""));
		assertFalse(Palindrome.isTextValid(" "));
		assertFalse(Palindrome.isTextValid("\n"));
		assertFalse(Palindrome.isTextValid("\t"));
		assertFalse(Palindrome.isTextValid("12"));
		assertFalse(Palindrome.isTextValid("a1"));
		assertFalse(Palindrome.isTextValid("a_"));
		assertFalse(Palindrome.isTextValid("!a"));
		assertFalse(Palindrome.isTextValid("a\\"));
		assertFalse(Palindrome.isTextValid("&&"));
		assertFalse(Palindrome.isTextValid(";a"));
		assertFalse(Palindrome.isTextValid("1a"));
		
	}
	
	/**
	 * Tests "isTextValid" method
	 */
	public void testIsTextPalindrome() {
		assertTrue(Palindrome.isTextPalindrome("abccba"));
		assertTrue(Palindrome.isTextPalindrome("abcdcba"));
		assertTrue(Palindrome.isTextPalindrome("a,b-c\"dc\"b,a"));
		assertTrue(Palindrome.isTextPalindrome("A man, a plan, a canal - Panama!"));
		assertTrue(Palindrome.isTextPalindrome("aaaaaaaaaa"));
		assertTrue(Palindrome.isTextPalindrome("aaaaaaaaaaa"));
		assertTrue(Palindrome.isTextPalindrome(String.join("", Collections.nCopies(1000, "aca"))));
		
		assertFalse(Palindrome.isTextPalindrome("abccbaa"));
		assertFalse(Palindrome.isTextPalindrome("abcdscba"));
		assertFalse(Palindrome.isTextPalindrome("-a,b-c\"dc\"b,a"));
		assertFalse(Palindrome.isTextPalindrome("A man, a pplan, a canal - Panama!"));
		assertFalse(Palindrome.isTextPalindrome("aaaaaabaaaaa"));
		
		
	}

}
