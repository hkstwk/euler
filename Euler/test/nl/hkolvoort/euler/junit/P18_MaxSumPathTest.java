package nl.hkolvoort.euler.junit;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import nl.hkolvoort.euler.P18_MaxSumPath;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class P18_MaxSumPathTest {
	private Integer result;
	private Integer expected;


	@Before
	public void setUp() throws Exception {
		result = new Integer(0);
		expected = new Integer(0);
		System.out.println("Start of MaxSumPathTest");
	}

	@After
	public void tearDown() throws Exception {
		result = null;
		expected = null;
		System.out.println("End of MaxSumPathTest");
	}

	@Test
	public void testMaxPathSumSmallTriangle() {
		P18_MaxSumPath msp;
		try {
			msp = new P18_MaxSumPath();
			msp.loadTriangleFile("C:\\Users\\Harm\\Documents\\p18.txt");
			expected = 1074;
			result = msp.findMaxSum(msp.getIntTriangleBig());
			assertEquals(expected, result);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

