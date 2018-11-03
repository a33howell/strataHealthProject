package strataHealthProject;

/**
 * Based on source code provided by Strata Health Solutions
 */
public interface RomanNumeralConverter {
    /**
     * Implemented function should take a String with the form of a Roman numeral
     * and return the integer represented by the numeral.
     * Throws an exception if input is invalid.
     *
     * @param romanNumeral - some Roman numeral to be converted into an integer
     * @return The integer representing "romanNumeral"
     * @throws IllegalArgumentException
     */
    public int fromRomanNumeral(String romanNumeral) throws IllegalArgumentException;
    /**
     * Implemented function should take an integer and convert it into a Roman numeral
     * Throws an exception if input is invalid (number is < 1).
     *
     * @param number - some integer to be converted into Roman numeral
     * @return The Roman numeral representing "number"
     * @throws IllegalArgumentException
     */
    public String toRomanNumeral(int number) throws IllegalArgumentException;
}

