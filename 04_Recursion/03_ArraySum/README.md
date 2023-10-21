#
Sum of Array Elements: Write a recursive function to calculate the sum of all elements in an array.
#

```java
public class ArraySum {
    public static int sumArray(int[] arr, int n) {
        // base case: if n becomes 0, return 0
        if (n == 0) {
            return 0;
        }
        // recursive case: add the current element to the sum of the remaining elements
        return arr[n - 1] + sumArray(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int sum = sumArray(array, array.length);
        System.out.println("Sum of array elements: " + sum);
    }
}
```

In this code, the `sumArray` function takes an array `arr` and an integer `n` as input and calculates the sum of all elements in the array using recursion. It first checks if `n` is 0, in which case it returns 0 (as the sum of an empty array is defined as 0). Otherwise, it recursively calls itself with the argument `n-1` and adds the current element `arr[n-1]` to the sum of the remaining elements. This process continues until `n` becomes 0, at which point the recursion stops and the final sum is returned.

The `main` function demonstrates the usage of the `sumArray` function by calculating the sum of all elements in an array and printing the result. In this example, the array `{1, 2, 3, 4, 5}` is used.
