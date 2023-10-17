public class Fibonacci {
    public static int fibonacci(int n) {
        // base cases: Fibonacci of 0 is 0, Fibonacci of 1 is 1
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        // recursive case: Fibonacci of n is the sum of Fibonacci of (n-1) and Fibonacci of (n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int number = 8;
        int result = fibonacci(number);
        System.out.println("The " + number + "th number in the Fibonacci sequence is: " + result);
    }
}
