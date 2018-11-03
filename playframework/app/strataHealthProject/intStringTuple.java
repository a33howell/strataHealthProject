package strataHealthProject;

/**
 * Tuple class created for the purposes of return values for numeralToDigit() in StandardNumeralConversion class
 * Tuple stores an int and a String
 *
 * @author	Andrew Howell
 * @version	1.0
 * @since	2018-11-01
 */
public class intStringTuple {
    private int num;
    private String text;

    /**
     * Constructor
     * @param num - int to be stored in tuple
     * @param text - String to be stored in tuple
     */
    public intStringTuple(int num, String text) {
        this.num = num;
        this.text = text;
    }

    /**
     * int getter function
     * @return int in the tuple
     */
    public int getInt() {return num;}
    /**
     * String getter function
     * @return String in the tuple
     */
    public String getString() {return text;}
}

