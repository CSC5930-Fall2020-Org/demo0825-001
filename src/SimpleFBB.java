
public class SimpleFBB {

    public static void main(String[] args) {
        // start with a simple loop
        // watch out for zero ;)
        for (int i = 0; i < 51; i++) {
            if (i % 3 == 0) {
                System.out.println("foo");
            }
            else {
                System.out.println(i);
            }
        }
    }

}
