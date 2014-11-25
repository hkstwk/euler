package nl.hkolvoort.euler.junit;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import nl.hkolvoort.euler.P3_LargestPrimeFactor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class P3_LargestPrimeFactorTest {
	private Long result;
	private Long expected;

	@Before
	public void setUp() throws Exception {
		Date date= new Date();
		result = new Long(0);
		expected = new Long(0);
		System.out.println(new Timestamp(date.getTime()) + ":  Start of LargestPrimeFactorTest");
	}

	@After
	public void tearDown() throws Exception {
		Date date= new Date();
		result = null;
		expected = null;
		System.out.println(new Timestamp(date.getTime()) + ":  End of LargestPrimeFactorTest");
	}

	@Test
	public void testLargestPrime13195() {
		P3_LargestPrimeFactor lpf = new P3_LargestPrimeFactor((long) 13195);
		expected = (long) 29;
		result = lpf.calcLargestPrimeFactor();
		assertEquals(expected, result);
	}
	
	@Test
	public void testLargestPrime() {
//		P3_LargestPrimeFactor lpf = new P3_LargestPrimeFactor((Long.valueOf("600851475143")));
		P3_LargestPrimeFactor lpf = new P3_LargestPrimeFactor((Long.valueOf("123452542")));
		expected = (long) 29;
		result = lpf.calcLargestPrimeFactor();
		assertEquals(expected, result);
	}
}
