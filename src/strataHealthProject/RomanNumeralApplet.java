package strataHealthProject;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI/Applet for StandardNumeralCovnersion class.
 * 
 * @author	Andrew Howell
 * @version	1.0
 * @since	2018-11-01
 */
public class RomanNumeralApplet extends Applet implements ActionListener {

	private static final long serialVersionUID = 1L;
	TextField intInput = new TextField();
	TextField numeralInput = new TextField();
	
	Label output1 = new Label("Enter an integer value on the left");
	Label output2 = new Label("Enter a Roman numeral on the left");
	
	Button button1 = new Button("= Convert to Roman numeral =>");
	Button button2 = new Button("= Convert to integer =>");
	
	StandardNumeralConversion converter = new StandardNumeralConversion();
	
	
	
	public void init() {
		// Add text inputs, buttons, and text outputs into a grid pattern
		setLayout(new GridLayout(2, 3));
		
		add(intInput);
		add(button1);
		add(output1);
		add(numeralInput);
		add(button2);
		add(output2);
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	
	
	// TODO functionality of button 1 and button 2 is fairly similar, find a way to trim down code in the future.
	@Override
	public void actionPerformed(ActionEvent e) {
		// Convert integer to Roman numeral
		if (e.getSource() == button1) {
			String input = intInput.getText();
			
			// Reject Blank inputs
			if(input.equals("")) {
				output1.setText("Please enter an integer");
				return;
			}
			
			try {
				// Convert int to numeral then print to screen
				output1.setText(converter.toRomanNumeral(Integer.parseInt(input)));
				
			// Exceptions
			} catch(NumberFormatException ex) {
				output1.setText("Please enter a valid integer");
			} catch(IllegalArgumentException ex) {
				output1.setText("Please enter an integer from 1 to 10,000");
			} catch(Exception ex) {
				output1.setText("Error encountered, please try again");
			}

		// Convert Roman numeral to integer
		} else if(e.getSource() == button2) {
			String input = numeralInput.getText();
			
			// Reject blank inputs
			if(input.equals("")) {
				output2.setText("Please enter a Roman numeral");
				return;
			}
			
			try {
				// Convert numeral to int then print to screen
				output2.setText(String.valueOf(converter.fromRomanNumeral(input)));
				
			// Exceptions
			} catch(IllegalArgumentException ex) {
				output2.setText("Please enter a valid Roman Numeral");
			} catch(Exception ex) {
				output2.setText("Error encountered, please try again");
			}
		}
	}
}
