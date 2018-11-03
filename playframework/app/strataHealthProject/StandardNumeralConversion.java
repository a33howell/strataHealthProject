package strataHealthProject;

/**
 * Class for converting values from standard form Roman numerals to integers and vice versa.
 *
 * @author	Andrew Howell
 * @version	1.0
 * @since	2018-11-01
 */
public class StandardNumeralConversion implements RomanNumeralConverter {

    /*
     * Roman numeral values for note-keeping purposes
     * I = 1
     * V = 5
     * X = 10
     * L = 50
     * C = 100
     * D = 500
     * M = 1000
     */

    // An array of valid Roman numeral characters  (I, V, X, L, C, D, M)
    public static final char[] VALID_NUMERALS = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};





    @Override
    public int fromRomanNumeral(String romanNumeral) throws IllegalArgumentException {
        // If input String contains invalid characters, throw an exception
        if(!hasValidChars(romanNumeral)) throw new IllegalArgumentException();

        int result = 0;

        // Inspect numerals in the 100s range, add appropriate number to final result
        while(!romanNumeral.equals("") && romanNumeral.charAt(0) == 'M') {
            result += 1000;
            romanNumeral = romanNumeral.substring(1);
        }

        // Inspect numerals in the 100s range, add appropriate number to final result
        intStringTuple tempTuple;
        tempTuple = numeralToDigit(romanNumeral, 100, 'C', 'D', 'M');
        result += tempTuple.getInt();
        romanNumeral = tempTuple.getString();

        // Inspect numerals in the 10s range, add appropriate number to final result
        tempTuple = numeralToDigit(romanNumeral, 10, 'X', 'L', 'C');
        result += tempTuple.getInt();
        romanNumeral = tempTuple.getString();

        // Inspect numerals in the 1s range, add appropriate number to final result
        tempTuple = numeralToDigit(romanNumeral, 1, 'I', 'V', 'X');
        result += tempTuple.getInt();
        romanNumeral = tempTuple.getString();

        // If romanNumeral isn't empty, then input must have had improper form, throw exception
        if (!romanNumeral.equals("")) throw new IllegalArgumentException();
        return result;
    }



    /**
     * Takes a String and determines if it is comprised of valid Roman numeral characters (I, V, X, L, C, D, M)
     * @param numeral - the String whose contents will be compared with valid Roman numeral characters
     * @return The truth value of whether all characters in the input String are valid
     */
    private Boolean hasValidChars(String numeral) {
        // Look at each character in the String, check if they are a valid Roman numeral character
        for(int i = 0; i < numeral.length(); i++)
            if(!isValidChar(numeral.charAt(i))) return false;

        return true;
    }

    /**
     * Takes a char and determines if it is a valid Roman numeral character (I, V, X, L, C, D, M)
     * @param value - the character to be compared with valid Roman numeral characters
     * @return The truth value of whether the input value is a valid character
     */
    private Boolean isValidChar(char value) {
        // Look at each valid Roman numeral character, check if the input value matches any of them
        for(int validChar: VALID_NUMERALS) if (value == validChar) return true;

        return false;
    }



    /**
     * Take a Roman numeral, and inspect the first few characters to determine the decimal value.
     *
     * @param numeral - the Roman numeral we want to inspect
     * @param decimal - the expected decimal range that we want to inspect (eg. 100s, 10s, 1s)
     * @param oneNumeral - the Roman numeral representing a singular multiple of the current decimal place (ex. 10s => X)
     * @param fiveNumeral - the Roman numeral representing a x5 multiple of the current decimal place (ex. 10 * 5 = 50 => L)
     * @param tenNumeral - the Roman numeral representing a x10 multiple of the current decimal place (ex. 10 * 10 = 100 => C)
     * @return The decimal value of the first characters in "numeral"
     * @throws IllegalArgumentException
     */
    private intStringTuple numeralToDigit(String numeral, int decimal, char oneNumeral,
                                          char fiveNumeral, char tenNumeral) throws IllegalArgumentException {

        // If numeral is empty, return nothing/zero
        if(numeral.equals("")) return new intStringTuple(0, "");

        int result = 0;
        String four = new StringBuilder().append(oneNumeral).append(fiveNumeral).toString();
        String nine = new StringBuilder().append(oneNumeral).append(tenNumeral).toString();

        // If first two characters represent x4 the current decimal place in subtractive notation,
        // then return 4 * decimal value and Roman numeral with removed characters
        if (numeral.length() > 1 && numeral.substring(0,2).equals(four))
            return new intStringTuple(4 * decimal, numeral.substring(2));

            // If first two characters represent x9 the current decimal place in subtractive notation,
            // then return 9 * decimal value and Roman numeral with removed characters
        else if (numeral.length() > 1 && numeral.substring(0,2).equals(nine))
            return new intStringTuple(9 * decimal, numeral.substring(2));

            // If first character represents x5 the current decimal place
            // then add 5 * decimal value to final result
        else if (numeral.charAt(0) == fiveNumeral) {
            numeral = numeral.substring(1);
            result += 5;
        }

        // If there's still singular characters representing singular quantities of the current decimal place,
        // then add them to the final result
        while(!numeral.equals("") && numeral.charAt(0) == oneNumeral) {
            result++;
            numeral = numeral.substring(1);
        }

        // There cannot be more than 3 "ones" after a "five" (ex. VIII, DCCC)
        // If the final result is greater than 8, then input was improper
        if (result > 8) throw new IllegalArgumentException();

        // Return the final result and Roman numeral with removed characters
        return new intStringTuple(result * decimal, numeral);
    }







    @Override
    public String toRomanNumeral(int number) throws IllegalArgumentException {
        // If input is less than one or greater than 10,000, then throw an exception
        // Roman numerals can only be positive number.
        // (upper bound was arbitrarily chosen to prevent massive outputs)
        if (number < 1 || number > 10000) throw new IllegalArgumentException();

        // Create blank string to append numerals onto
        StringBuilder numeral = new StringBuilder();

        // Append appropriate number of 'M' numerals to output for the 1000s decimal place
        int temp = number/1000;
        number %= 1000;
        while(temp > 0) {
            numeral.append('M');
            temp--;
        }

        // Append appropriate numerals to output for the 100s decimal place
        numeral.append(digitToNumeral(number, 100, 'C', 'D', 'M'));
        number %= 100;

        // Append appropriate numerals to output for the 10s decimal place
        numeral.append(digitToNumeral(number, 10, 'X', 'L', 'C'));
        number %= 10;

        // Append appropriate numerals to output for the 1s decimal place
        numeral.append(digitToNumeral(number, 1, 'I', 'V', 'X'));

        return numeral.toString();
    }



    /**
     * Take a digit/decimal place from a number, and determine the appropriate Roman numerals to represent it
     *
     * @param number - number we want to convert into a Roman numeral
     * @param decimal - the current decimal place we want to inspect (eg. 100s, 10s, 1s)
     * @param oneNumeral - the Roman numeral representing a singular multiple of the current decimal place (ex. 10s => X)
     * @param fiveNumeral - the Roman numeral representing a x5 multiple of the current decimal place (ex. 10 * 5 = 50 => L)
     * @param tenNumeral - the Roman numeral representing a x10 multiple of the current decimal place (ex. 10 * 10 = 100 => C)
     * @return Roman numerals representing the digit of interest in "number"
     */
    private String digitToNumeral(int number, int decimal, char oneNumeral,
                                  char fiveNumeral, char tenNumeral) {

        // Create blank string to append numerals onto
        StringBuilder numeral = new StringBuilder();

        // Find digit of interest in number (ex. 10s digit in 50 is 5)
        int digit = number/decimal;

        // If current digit is a 4,
        // then return two characters representing x4 the current decimal place in subtractive notation
        if (digit == 4) return numeral.append(oneNumeral).append(fiveNumeral).toString();

            // If current digit is a 9,
            // then return two characters representing x9 the current decimal place in subtractive notation
        else if (digit == 9) return numeral.append(oneNumeral).append(tenNumeral).toString();

            // If current digit is >= 5, then append a x5 numeral to the final result
        else if (digit >= 5) {
            numeral.append(fiveNumeral);
            digit -= 5;
        }

        // Append the appropriate number of x1 numerals to the final result
        while(digit > 0) {
            numeral.append(oneNumeral);
            digit--;
        }

        return numeral.toString();
    }

}

