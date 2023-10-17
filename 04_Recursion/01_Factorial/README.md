
```java
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
```

In this code, the `factorial` function takes an integer `n` as input and calculates its factorial using recursion. It first checks if `n` is 0, in which case it returns 1 (as the factorial of 0 is defined as 1). Otherwise, it recursively calls itself with the argument `n-1` and multiplies the result by `n`. This process continues until `n` reaches 0, at which point the recursion stops and the final factorial value is returned.

The `main` function demonstrates the usage of the `factorial` function by calculating the factorial of the number 5 and printing the result.
