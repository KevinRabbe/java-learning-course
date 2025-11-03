public class ExceptionBeispiele {
    public static void main(String[] args) {
        // Example of ArithmeticException
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: Division by zero!");
        } finally {
            System.out.println("Finished ArithmeticException example.");
        }

        // Example of NullPointerException
        String str = null;
        try {
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: Attempt to access length of null!");
        } finally {
            System.out.println("Finished NullPointerException example.");
        }

        // Example of ArrayIndexOutOfBoundsException
        int[] numbers = {1, 2, 3};
        try {
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: Index out of bounds!");
        } finally {
            System.out.println("Finished ArrayIndexOutOfBoundsException example.");
        }
    }
}