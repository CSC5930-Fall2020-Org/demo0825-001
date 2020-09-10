
/**
 * Alleged logic: if x is between 0 and 100, it's in range if it's over 100,
 * it's out of range if less than zero, indicate it's negative
 */

public class DanglingElseDemo {

    private static final String WITHIN_RANGE = "range is nominal";

    public static void main(String[] args) {
        int gameScore = -42;

        analyzeGameScore(gameScore);
    }

    protected static void analyzeGameScore(int gameScore) {
        if (gameScore > 0)
            if (gameScore < 100)
                System.out.println(WITHIN_RANGE);
        else
            System.out.println("x is negative");

    }

}
