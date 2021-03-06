package strataHealthProject;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit test class containing tests for for StandardNumeralConversion class
 * 
 * @author	Andrew Howell
 * @version	1.0
 * @since	2018-11-01
 */
public class JUnitTesting {
	StandardNumeralConversion temp = new StandardNumeralConversion();

	/*
	 * ----- fromRomanNumeral() tests -----
	 */
	
	@Test
	public void testFromNumeral1() {
		assertEquals(2018, temp.fromRomanNumeral("MMXVIII"));
	}
	
	@Test
	public void testFromNumeral2() {
		assertEquals(333, temp.fromRomanNumeral("CCCXXXIII"));
	}
	
	@Test
	public void testFromNumeral3() {
		assertEquals(400, temp.fromRomanNumeral("CD"));
	}
	
	@Test
	public void testFromNumeral4() {
		assertEquals(1239, temp.fromRomanNumeral("MCCXXXIX"));
	}
	
	@Test
	public void testFromNumeral5() {
		assertEquals(10000, temp.fromRomanNumeral("MMMMMMMMMM"));
	}
	
	@Test
	public void testFromNumeral6() {
		assertEquals(1, temp.fromRomanNumeral("I"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFromNumeral7() {
		temp.fromRomanNumeral("MMMZIII");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFromNumeral8() {
		temp.fromRomanNumeral("MMMCCCMMMM");
	}
	
	
	
	
	
	
	/*
	 * ----- toRomanNumeral() tests -----
	 */
	
	@Test
	public void testToNumeral1() {
		assertEquals("MMXVIII", temp.toRomanNumeral(2018));
	}
	
	@Test
	public void testToNumeral2() {
		assertEquals("CCCXXXIII", temp.toRomanNumeral(333));
	}
	
	@Test
	public void testToNumeral3() {
		assertEquals("CD", temp.toRomanNumeral(400));
	}

	@Test
	public void testToNumeral4() {
		assertEquals("MCCXXXIX", temp.toRomanNumeral(1239));
	}
	
	@Test
	public void testToNumeral5() {
		assertEquals("MMMMMMMMMM", temp.toRomanNumeral(10000));
	}
	
	@Test
	public void testToNumeral6() {
		assertEquals("I", temp.toRomanNumeral(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testToNumeral7() {
		temp.toRomanNumeral(10001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testToNumeral8() {
		temp.toRomanNumeral(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testToNumeral9() {
		temp.toRomanNumeral(-1);
	}
}
