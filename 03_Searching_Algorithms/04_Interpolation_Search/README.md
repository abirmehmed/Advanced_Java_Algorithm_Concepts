#
Interpolation Search: Implement the interpolation search algorithm to find a target element in a sorted array by estimating the position based on the values at the ends.
#
```java
public class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right && target >= arr[left] && target <= arr[right]) {
            int pos = left + ((target - arr[left]) * (right - left)) / (arr[right] - arr[left]);

            if (arr[pos] == target) {
                return pos;
            }

            if (arr[pos] < target) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }

        return -1; // If the target element is not found, return -1
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
        int target = 12;

        int index = interpolationSearch(arr, target);

        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }
    }
}
```

#### Explanation of the Code:

The code above implements the Interpolation Search algorithm in Java. Here's how it works:

1. The `interpolationSearch` method takes a sorted array of integers (`arr`) and a target element (`target`) as input and returns the index of the target element if found, or -1 if not found.

2. It initializes the left index (`left`) as 0 and the right index (`right`) as the last index of the array.

3. It enters a while loop that continues as long as the `left` index is less than or equal to the `right` index, and the target element is greater than or equal to the element at the `left` index and less than or equal to the element at the `right` index.

4. Inside the loop, it calculates the estimated position (`pos`) of the target element using the interpolation formula: `pos = left + ((target - arr[left]) * (right - left)) / (arr[right] - arr[left])`. This formula estimates the position by taking into account the values at the ends of the array.

5. If the element at the estimated position (`arr[pos]`) is equal to the target element, the method returns the `pos` index.

6. If the element at the estimated position is less than the target element, it means the target element should be present in the right half of the array. So, it updates the `left` index as `pos + 1`.

7. If the element at the estimated position is greater than the target element, it means the target element should be present in the left half of the array. So, it updates the `right` index as `pos - 1`.

8. After exiting the while loop, it means the target element is not present in the array, so the method returns -1.

9. In the `main` method, an example sorted array `{2, 4, 6, 8, 10, 12, 14, 16, 18, 20}` is created, and the target element is set to 12.

10. The `interpolationSearch` method is called with the array and target element as arguments, and the returned index is stored in the `index` variable.

11. If the returned index is not -1, it means the target element is found, so a message is printed indicating the index where the element is found. Otherwise, a message is printed indicating that the element is not found in the array.

The output of the above code will be:
```
Element found at index 5
```

That's it! The code implements the Interpolation Search algorithm in Java to find a target element in a sorted array by estimating the position based on the values at the ends.
