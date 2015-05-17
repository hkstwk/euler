package nl.hkolvoort.euler.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import nl.hkolvoort.euler.P004_LargestPalindromeProduct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class P004_LargestPalindromeProductTest {
	private Integer expected;
	private Integer result;
	
	@Before
	public void setUp() throws Exception {
		expected = 0;
		result = 0;

		System.out.println("Start of SumSquareDiffTest");
	}

	@After
	public void tearDown() throws Exception {
		expected = 0;
		result = 0;
		System.out.println("End of SumSquareDiffTest");
	}

	@Test
	public void testRevertString() {
		Integer input = 9091;
		this.expected = 1909;
		P004_LargestPalindromeProduct p4 = new P004_LargestPalindromeProduct();
		this.result = p4.getReverseNumber(input);
		assertEquals(expected, result);
	}
	
	@Test
	public void testIsPalindrome(){
		Integer input = 9009;
		P004_LargestPalindromeProduct p4 = new P004_LargestPalindromeProduct();
		assertTrue(p4.isPalindrome(input));
	}

	@Test
	public void testIsNoPalindrome(){
		Integer input = 1234;
		P004_LargestPalindromeProduct p4 = new P004_LargestPalindromeProduct();
		assertFalse(p4.isPalindrome(input));
	}
	
	@Test
	public void testLargestPalindromeTwoDigits(){
		P004_LargestPalindromeProduct p4 = new P004_LargestPalindromeProduct();
		p4.findPalindromes(10,100,p4.DEBUG);
		expected = 9009;
		result = p4.getLargestPalindrome();
		assertEquals(expected, result);
	}}
