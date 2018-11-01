package strataHealthProject;

public interface RomanNumeralConverter {
	public int fromRomanNumeral(String romanNumeral);
	public String toRomanNumeral(int number) throws IllegalArgumentException;
}
