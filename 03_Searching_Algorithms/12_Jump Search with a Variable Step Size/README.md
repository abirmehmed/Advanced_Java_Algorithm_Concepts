#
Jump Search with a Variable Step Size: Implement a modified version of the jump search algorithm where the step size is determined dynamically based on the array size and the target element's position.
#

```java
public class JumpSearch {
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;

        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));

            if (prev >= n) {
                return -1; // Target not found
            }
        }

        while (arr[prev] < target) {
            prev++;

            if (prev == Math.min(step, n)) {
                return -1; // Target not found
            }
        }

        if (arr[prev] == target) {
            return prev; // Found target at index prev
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 9;

        int result = jumpSearch(arr, target);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + result);
        }
    }
}
```

In this implementation, the `jumpSearch` method takes an array `arr` and a target element `target` as input. It starts by calculating the step size as the square root of the array size using `Math.sqrt`. The variable `prev` keeps track of the previous step position.

The first while loop is used to jump ahead in the array with a variable step size until the value at the current step position is greater than or equal to the target element. If the current step position exceeds the array size, the target element is not found, and `-1` is returned.

The second while loop does a linear search from the previous step position to the current step position or the end of the array, comparing the elements with the target element. If the target element is found, the method returns the index. Otherwise, if the current element is greater than the target element, the target element is not present in the array, and `-1` is returned.

In the `main` method, an example array is defined, and the `jumpSearch` method is called with a target value of 9. The result is then printed to the console.

This modified version of the jump search algorithm adjusts the step size dynamically based on the array size and the target element's position, allowing for faster search times in certain cases.
