

```java
public class PowerFunction {
    public static double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent > 0) {
            return base * power(base, exponent - 1);
        } else {
            return 1 / (base * power(base, -exponent));
        }
    }

    public static void main(String[] args) {
        double base = 2;
        int exponent = 3;
        double result = power(base, exponent);
        System.out.println(base + " raised to the power of " + exponent + " is: " + result);
    }
}
```

In this code, the recursive function `power` takes a `base` and an `exponent` as input and returns the result of base raised to the power of the exponent.

The base cases are when the exponent is 0, in which case the function returns 1.

In the recursive case, if the exponent is greater than 0, the function multiplies the base with the result of the recursive call to `power` with the exponent decreased by 1.

If the exponent is less than 0, the function calculates the reciprocal of the product of the base and the result of the recursive call to `power` with the exponent itself (without changing the sign).

In the `main` method, we call the `power` function with a base of 2 and an exponent of 3, and print the result.

When you run this code, it will output the result of 2 raised to the power of 3, which is 8.
