import uk.ac.aber.dcs.cs22120.json_spike_work.JSONProcessor;
import uk.ac.aber.dcs.cs22120.json_spike_work.Word;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The main Application class.
 *
 * @author jor69
 * @version 1.1.0
 */

public class Application {

    //Instance variables
    private JSONProcessor json;
    private ArrayList<Word> words;
    private Scanner input;
    private String filename;

    //Initialise instance variables in the class constructor
    private Application() {
        json = new JSONProcessor();
        words = new ArrayList<>();
        input = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        boolean success = false;

        System.out.println("Please enter filename:");
        filename = input.next();
        success = json.read(filename);

        while(success != true) {
            System.err.println("\nFile not found. Please try again.");
            System.out.println("Please enter filename:");
            filename = input.next();
            success = json.read(filename);
        }

        words = json.export();

        System.out.println(words.toString());
        json.write(filename);
    }
}
