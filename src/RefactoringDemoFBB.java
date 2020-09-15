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

            String transformedResult = transform(test);
            outFile.println(transformedResult);
        } // End of While Loop
        outFile.close();
    }

    protected void runConsole() {
        String count;
        double test = 0;
        Scanner scan = new Scanner(System.in);
        String answer = "";

        while (!answer.equals("Stop")) {

            System.out.println("Please Enter a Value: ");
            count = scan.nextLine();
            count.trim();

            try {
                test = Double.parseDouble(count);
            }
            catch (NumberFormatException e) {
                System.out.println(count + " = Invalid Input");
                continue;
            }

            if (test < 0) {
                System.out.println(count + " = Invalid Input");
                continue;
            }

            if (test > Integer.MAX_VALUE) {
                System.out.println(count + " = Invalid Input");
                continue;
            }

            if (test % 1 != 0) {
                System.out.println(count + " = Invalid Input");
                continue;
            }

            // Note that the original implementation has a bug -
            // it doesn't "count up" in console mode
            String transformedResult = transform(test);
            System.out.println(transformedResult);

            System.out.println(
                    "Would you like to End Program? (Type \"Stop\" to End) ");
            answer = scan.nextLine();
        } // End of While Loop
    }

    protected String transform(double test) {
        StringBuilder buffer = new StringBuilder();

        if (test % 3 == 0) {
            buffer.append("Foo");
        }

        if (test % 5 == 0) {
            buffer.append("Bar");
        }

        if (test % 7 == 0) {
            buffer.append("Baz");
        }

        if (test % 7 != 0 && test % 5 != 0 && test % 3 != 0) {
            int printValue = (int) test;
            buffer.append(printValue);
        }

        return buffer.toString();
    }
}