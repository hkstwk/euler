package nl.hkolvoort.euler.junit;

import static org.junit.Assert.assertEquals;
import nl.hkolvoort.euler.P6_SumSquareDiff;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class P6_SumSquareDiffTest {
	private Integer result;
	private Integer expected;


	@Before
	public void setUp() throws Exception {
		result = new Integer(0);
		expected = new Integer(0);
		System.out.println("Start of SumSquareDiffTest");
	}

	@After
	public void tearDown() throws Exception {
		result = null;
		expected = null;
		System.out.println("End of SumSquareDiffTest");
	}

	@Test
	public void testFirstTenNaturals() {
		P6_SumSquareDiff sqd;
		sqd = new P6_SumSquareDiff();
		expected = 2640;
		result = sqd.getDifference();
		assertEquals(expected, result);
	}
}

