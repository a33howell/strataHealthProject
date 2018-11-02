package strataHealthProject;

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
	
	public static final char[] VALID_NUMERALS = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
	
	
	
	
	
	@Override
	public int fromRomanNumeral(String romanNumeral) throws IllegalArgumentException {
		if(!hasValidChars(romanNumeral)) throw new IllegalArgumentException();
		
		int result = 0;
		
		while(!romanNumeral.equals("") && romanNumeral.charAt(0) == 'M') {
			result += 1000;
			romanNumeral = romanNumeral.substring(1);
		}
		
		intStringTuple tempTuple;
		tempTuple = numeralToDigit(romanNumeral, 100, 'C', 'D', 'M');
		result += tempTuple.getInt();
		romanNumeral = tempTuple.getString();
		
		tempTuple = numeralToDigit(romanNumeral, 10, 'X', 'L', 'C');
		result += tempTuple.getInt();
		romanNumeral = tempTuple.getString();
		
		tempTuple = numeralToDigit(romanNumeral, 1, 'I', 'V', 'X');
		result += tempTuple.getInt();
		romanNumeral = tempTuple.getString();
			
		if (!romanNumeral.equals("")) throw new IllegalArgumentException();
		return result;
	}
	
	
	
	/**
	 * 
	 * @param numeral
	 * @return
	 */
	private Boolean hasValidChars(String numeral) {
		for(int i = 0; i < numeral.length(); i++)
			if(!isValidChar(numeral.charAt(i))) return false;

		return true;
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	private Boolean isValidChar(char value) {
		for(int validChar: VALID_NUMERALS) if (value == validChar) return true;
		
		return false;
	}
	
	
	
	/**
	 * 
	 * @param numeral
	 * @param decimal
	 * @param oneNumeral
	 * @param fiveNumeral
	 * @param tenNumeral
	 * @return
	 * @throws IllegalArgumentException
	 */
	private intStringTuple numeralToDigit(String numeral, int decimal, char oneNumeral,
			char fiveNumeral, char tenNumeral) throws IllegalArgumentException {
		
		if(numeral.equals("")) return new intStringTuple(0, "");
		
		int result = 0;
		String four = new StringBuilder().append(oneNumeral).append(fiveNumeral).toString();
		String nine = new StringBuilder().append(oneNumeral).append(tenNumeral).toString();
		
		if (numeral.length() > 1 && numeral.substring(0,2).equals(four))
			return new intStringTuple(4 * decimal, numeral.substring(2));
		
		else if (numeral.length() > 1 && numeral.substring(0,2).equals(nine))
			return new intStringTuple(9 * decimal, numeral.substring(2));
		
		else if (numeral.charAt(0) == fiveNumeral) {
			numeral = numeral.substring(1);
			result += 5;
		}

		while(!numeral.equals("") && numeral.charAt(0) == oneNumeral) {
			result++;
			numeral = numeral.substring(1);
		}
		
		if (result > 8) throw new IllegalArgumentException();
		
		return new intStringTuple(result * decimal, numeral);
	}
	
	
	
	
	
	

	@Override
	public String toRomanNumeral(int number) throws IllegalArgumentException {
		if (number < 1 || number > 10000) throw new IllegalArgumentException();
		
		StringBuilder numeral = new StringBuilder();
		int temp = number/1000;
		number %= 1000;
		while(temp > 0) {
			numeral.append('M');
			temp--;
		}
		
		numeral.append(digitToNumeral(number, 100, 'C', 'D', 'M'));
		number %= 100;
		numeral.append(digitToNumeral(number, 10, 'X', 'L', 'C'));
		number %= 10;
		numeral.append(digitToNumeral(number, 1, 'I', 'V', 'X'));
		
		return numeral.toString();
	}
	
	
	
	/**
	 * 
	 * @param number
	 * @param decimal
	 * @param oneNumeral
	 * @param fiveNumeral
	 * @param tenNumeral
	 * @return
	 */
	private String digitToNumeral(int number, int decimal, char oneNumeral,
			char fiveNumeral, char tenNumeral) {
		
		StringBuilder numeral = new StringBuilder();
		int temp = number/decimal;
		
		if (temp == 4) return numeral.append(oneNumeral).append(fiveNumeral).toString();
		else if (temp == 9) return numeral.append(oneNumeral).append(tenNumeral).toString();
		else if (temp >= 5) {
			numeral.append(fiveNumeral);
			temp -= 5;
		}
		while(temp > 0) {
			numeral.append(oneNumeral);
			temp--;
		}
		
		return numeral.toString();
	}

}
