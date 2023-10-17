#
Fibonacci Sequence: Write a recursive function to generate the nth number in the Fibonacci sequence. in java . 
#
```java
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
```

In this code, the `fibonacci` function takes an integer `n` as input and calculates the nth number in the Fibonacci sequence using recursion. It first checks if `n` is 0 or 1, in which case it returns 0 or 1 respectively (as these are the base cases for the Fibonacci sequence). Otherwise, it recursively calls itself with the arguments `n-1` and `n-2`, and returns the sum of the two previous Fibonacci numbers. This process continues until it reaches the base cases, at which point the recursion stops and the final Fibonacci number

