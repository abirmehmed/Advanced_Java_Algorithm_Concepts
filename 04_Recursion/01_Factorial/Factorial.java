public class Factorial {
    public static int factorial(int n) {
        // base case: factorial of 0 is 1
        if (n == 0) {
            return 1;
        }
        // recursive case: factorial of n is n multiplied by factorial of (n-1)
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int number = 5;
        int result = factorial(number);
        System.out.println("Factorial of " + number + " is: " + result);
    }
}
