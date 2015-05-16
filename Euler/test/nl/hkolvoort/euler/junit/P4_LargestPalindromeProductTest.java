package nl.hkolvoort.euler.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import nl.hkolvoort.euler.P4_LargestPalindromeProduct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class P4_LargestPalindromeProductTest {
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
		P4_LargestPalindromeProduct p4 = new P4_LargestPalindromeProduct();
		this.result = p4.getReverseNumber(input);
		assertEquals(expected, result);
	}
	
	@Test
	public void testIsPalindrome(){
		Integer input = 9009;
		P4_LargestPalindromeProduct p4 = new P4_LargestPalindromeProduct();
		assertTrue(p4.isPalindrome(input));
	}

	@Test
	public void testIsNoPalindrome(){
		Integer input = 1234;
		P4_LargestPalindromeProduct p4 = new P4_LargestPalindromeProduct();
		assertFalse(p4.isPalindrome(input));
	}
}
