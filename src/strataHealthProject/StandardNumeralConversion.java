package strataHealthProject;
import java.io.*;
import java.util.*;

public class StandardNumeralConversion implements RomanNumeralConverter {
	
	// Numerals and their values
	public static final int I = 1;
	public static final int V = 5;
	public static final int X = 10;
	public static final int L = 50;
	public static final int C = 100;
	public static final int D = 500;
	public static final int M = 1000;
	
	
	
	
	
	@Override
	public int fromRomanNumeral(String romanNumeral) {

		return 0;
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
