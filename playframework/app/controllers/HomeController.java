package controllers;

import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.*;
import play.data.Form;
import strataHealthProject.*;

import javax.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    String output1 = "Please enter an integer";
    String output2 = "Please enter a Roman numeral";
    StandardNumeralConversion converter = new StandardNumeralConversion();
    private final FormFactory formFactory;

    @Inject
    public HomeController(final FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render(output1, output2));
    }

    public Result toRomanNumeral() {
        DynamicForm requestData = formFactory.form().bindFromRequest();
        String input = requestData.get("intInput");

        // Reject Blank inputs
        if(input.equals("")) {
            output1 = "Please enter an integer";
            return ok(views.html.index.render(output1, output2));
        }

        try {
            // Convert int to numeral then print to screen
            output1 = converter.toRomanNumeral(Integer.parseInt(input));

            // Exceptions
        } catch(NumberFormatException ex) {
            output1 = "Please enter a valid integer";
        } catch(IllegalArgumentException ex) {
            output1 = "Please enter an integer from 1 to 10,000";
        } catch(Exception ex) {
            output1 = "Error encountered, please try again";
        }

        return ok(views.html.index.render(output1, output2));
    }

    public Result fromRomanNumeral() {
        DynamicForm requestData = formFactory.form().bindFromRequest();
        String input = requestData.get("numeralInput");

        // Reject blank inputs
        if(input.equals("")) {
            output2 = "Please enter a Roman numeral";
            return ok(views.html.index.render(output1, output2));
        }

        try {
            // Convert numeral to int then print to screen
            output2 = String.valueOf(converter.fromRomanNumeral(input));

            // Exceptions
        } catch(IllegalArgumentException ex) {
            output2 = "Please enter a valid Roman Numeral";
        } catch(Exception ex) {
            output2 = "Error encountered, please try again";
        }

        return ok(views.html.index.render(output1, output2));
    }

}
