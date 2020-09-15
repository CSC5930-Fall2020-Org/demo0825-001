import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//Student code from a prior semester - used to demo Checkstyle
public class RefactoringDemoFBB {

    public static void main(String args[])
            throws FileNotFoundException, IOException {

        RefactoringDemoFBB demoFbb = new RefactoringDemoFBB();
        demoFbb.run(args);
    }

    protected void run(String[] args) throws FileNotFoundException {
        String count = "0";
        String argument = "";

        if (args.length == 0) {
            argument = "console";
        }

        else {
            argument = args[0];
        }

        if (argument == "batch") {
            runBatch();
        }

        if (argument == "console") {
            runConsole();
        }
    }

    protected void runBatch() throws FileNotFoundException {
        String count;
        double test = 0;
        // Path filepath = Paths.get("\\src\\resources\\fbb-input.txt");
        File filepath = new File(".\\src\\fbb-input.txt");
        Scanner scanFile = new Scanner(filepath);
        PrintWriter outFile = new PrintWriter("fbb-actual-output.txt");

        while (scanFile.hasNext()) {
            count = scanFile.nextLine();
            count.trim();

            try {
                test = Double.parseDouble(count);
            }
            catch (NumberFormatException e) {
                outFile.println(count + " = Invalid Input");
                continue;
            }

            if (test < 0) {
                outFile.println(count + " = Invalid Input");
                continue;
            }

            if (test > Integer.MAX_VALUE) {
                outFile.println(count + " = Invalid Input");
                continue;
            }

            if (test % 1 != 0) {
                outFile.println(count + " = Invalid Input");
                continue;
            }

            String transformedValue = transform(test);
            outFile.println(transformedValue);

        } // End of While Loop
        outFile.close();
    }

    protected void runConsole() {
        String count;
        double userInput = 0;
        Scanner scan = new Scanner(System.in);
        String answer = "";

        while (!answer.equals("Stop")) {

            System.out.println("Please Enter a Value: ");
            count = scan.nextLine();
            count.trim();

            try {
                userInput = Double.parseDouble(count);
            }
            catch (NumberFormatException e) {
                System.out.println(count + " = Invalid Input");
                continue;
            }

            if (userInput < 0) {
                System.out.println(count + " = Invalid Input");
                continue;
            }

            if (userInput > Integer.MAX_VALUE) {
                System.out.println(count + " = Invalid Input");
                continue;
            }

            if (userInput % 1 != 0) {
                System.out.println(count + " = Invalid Input");
                continue;
            }

            String transformedValue = transform(userInput);
            System.out.println(transformedValue);

            System.out.println(
                    "Would you like to End Program? (Type \"Stop\" to End) ");
            answer = scan.nextLine();

        } // End of While Loop
    }

    protected String transform(double userInput) {
        StringBuilder buffer = new StringBuilder();

        if (userInput % 3 == 0) {
            buffer.append("Foo");
        }

        if (userInput % 5 == 0) {
            buffer.append("Bar");
        }

        if (userInput % 7 == 0) {
            buffer.append("Baz");
        }

        if (userInput % 7 != 0 && userInput % 5 != 0 && userInput % 3 != 0) {
            int printValue = (int) userInput;
            buffer.append(printValue);
        }

        return buffer.toString();
    }

}