#
Exponential Search: Implement the exponential search algorithm to find a target element in a sorted array by doubling the search range until a potential range is found.
#

```java
public class ExponentialSearch {
    public static int exponentialSearch(int[] arr, int target) {
        // If the target element is the first element in the array
        if (arr[0] == target) {
            return 0;
        }

        // Find the range for binary search
        int i = 1;
        while (i < arr.length && arr[i] <= target) {
            i *= 2;
        }

        // Perform binary search within the determined range
        int left = i / 2;
        int right = Math.min(i, arr.length - 1);

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // If the target element is not found, return -1
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
        int target = 12;

        int index = exponentialSearch(arr, target);

        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }
    }
}
```

#### Explanation of the Code:

The code above implements the Exponential Search algorithm in Java. Here's how it works:

1. The `exponentialSearch` method takes a sorted array of integers (`arr`) and a target element (`target`) as input and returns the index of the target element if found, or -1 if not found.

2. It first checks if the target element is the first element in the array. If it is, it returns 0 as the index.

3. If the target element is not the first element, it starts by finding the range for binary search. It initializes `i` as 1 and doubles it until `i` becomes greater than or equal to the length of the array or the element at index `i` becomes greater than the target element.

4. After finding the range, it performs binary search within that range. It initializes the `left` index as `i / 2` and the `right` index as the minimum between `i` and the last index of the array.

5. It enters a while loop that continues as long as the `left` index is less than or equal to the `right` index.

6. Inside the loop, it calculates the mid index as `left + (right - left) / 2`.

7. If the element at the mid index (`arr[mid]`) is equal to the target element, the method returns the `mid` index.

8. If the element at the mid index is less than the target element, it updates the `left` index as `mid + 1`.

9. If the element at the mid index is greater than the target element, it updates the `right` index as `mid - 1`.

10. After exiting the while loop, it means the target element is not present in the array, so the method returns -1.

11. In the `main` method, an example sorted array `{2, 4, 6, 8, 10, 12, 14, 16, 18, 20}` is created, and the target element is set to 12.

12. The `exponentialSearch` method is called with the array and target element as arguments, and the returned index is stored in the `index` variable.

13. If the returned index is not -1, it means the target element is found, so a message is printed indicating the index where the element is found. Otherwise, a message is printed indicating that the element is not found in the array.

The output of the above code will be:
```
Element found at index 5
```

That's it! The code implements the Exponential Search algorithm in Java to find a target element in a sorted array by doubling the search range until a potential range is found.
