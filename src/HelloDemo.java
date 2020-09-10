import java.util.Scanner;

public class HelloDemo {

    public static void main(String[] args) {
        
        //if args[0] is console
        //else do batch

        if (args != null && args.length > 0) {
            for (String arg : args) {
                System.out.println("Hello " + arg);
            }
        }
        else {
            System.out.println("No args specified");
        }
        System.out.println("Try again");

        System.out.println("???");

        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        // NumberFormatException

        return;
    }

}
