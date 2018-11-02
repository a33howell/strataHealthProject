package strataHealthProject;

public class intStringTuple {
	private int num;
	private String text;
	
	/**
	 * 
	 * @param num
	 * @param text
	 */
	public intStringTuple(int num, String text) {
		this.num = num;
		this.text = text;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getInt() {return num;}
	/**
	 * 
	 * @return
	 */
	public String getString() {return text;}
}
