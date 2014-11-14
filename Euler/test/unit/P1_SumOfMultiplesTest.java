package unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import hkol.P1_SumOfMultiples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class P1_SumOfMultiplesTest {
	private Integer result;
	private boolean multiple; 
	private P1_SumOfMultiples som;
	
	@Before
	public void setUp() throws Exception {
		result = 0;
		som = new P1_SumOfMultiples();
	}

	@After
	public void tearDown() throws Exception {
		result = 0;
		som = null;
	}

	/**
	 * test sum of all mutliples of 3 and 5 below 10.
	 * Mutliples of 3 below 10 are: 3, 6 and 9
	 * Multiples of 5 below 10 are: 5
	 * Sum should be 3 + 5 + 6 + 9 = 23
	 */
	@Test
	public void testSum10() {
		result = som.sum(3,5,10);
		Integer expected = 23;
		assertEquals(expected, result);
	}
	
	/**
	 * Test if number is multiple of divider
	 * 3 is divider of 3 ==> true
	 */
	@Test
	public void testIsMultiple() {
		multiple = som.isMultiple(3, 3);
		assertTrue(multiple);
	}
	
	
	/**
	 * Test if number is multiple of divider
	 * 3 is not divider of 4 ==> false
	 */
	@Test
	public void testIsNotMultiple() {
		multiple = som.isMultiple(4, 3);
		assertFalse(multiple);
	}

}
