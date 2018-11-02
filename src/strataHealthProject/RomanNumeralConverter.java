package strataHealthProject;

public interface RomanNumeralConverter {
	/**
	 * 
	 * @param romanNumeral
	 * @return
	 * @throws IllegalArgumentException
	 */
	public int fromRomanNumeral(String romanNumeral) throws IllegalArgumentException;
	/**
	 * 
	 * @param number
	 * @return
	 * @throws IllegalArgumentException
	 */
	public String toRomanNumeral(int number) throws IllegalArgumentException;
}
