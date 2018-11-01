package strataHealthProject;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTesting {
	StandardNumeralConversion temp = new StandardNumeralConversion();

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
