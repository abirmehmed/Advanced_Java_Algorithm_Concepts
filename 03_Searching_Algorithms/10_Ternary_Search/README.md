
```java
public class TernarySearch {
    public static int ternarySearch(int[] arr, int target) {
        int left = 0; // left pointer
        int right = arr.length - 1; // right pointer

        while (left <= right) {
            int mid1 = left + (right - left) / 3; // calculate the first mid
            int mid2 = right - (right - left) / 3; // calculate the second mid

            if (arr[mid1] == target) {
                return mid1; // found target at mid1
            }

            if (arr[mid2] == target) {
                return mid2; // found target at mid2
            }

            if (target < arr[mid1]) {
                right = mid1 - 1; // search the left third
            } else if (target > arr[mid2]) {
                left = mid2 + 1; // search the right third
            } else {
                left = mid1 + 1; // search the middle third
                right = mid2 - 1;
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 9;

        int result = ternarySearch(arr, target);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + result);
        }
    }
}
```

In this implementation, the `ternarySearch` method takes an array `arr` and a target element `target` as input. It initializes the left and right pointers to the start and end indices of the array, respectively.

The algorithm then enters a while loop, which continues as long as the left pointer is less than or equal to the right pointer. Inside the loop, it calculates the first mid index (`mid1`) and the second mid index (`mid2`) by dividing the remaining array into three parts.

If the target element is found at `mid1` or `mid2`, the method returns the respective index. If the target element is less than the element at `mid1`, the algorithm updates the right pointer to `mid1 - 1` to search the left third of the array. If the target element is greater than the element at `mid2`, the algorithm updates the left pointer to `mid2 + 1` to search the right third of the array. If the target element is between the elements at `mid1` and `mid2`, the algorithm updates both pointers to search the middle third of the array.

If the target element is not found after the while loop, the method returns -1 to indicate that the element was not found in the array.

In the `main` method, an example array is defined, and the `ternarySearch` method is called with a target value of 9. The result is then printed to the console.

Please note that this implementation assumes that the input array is sorted in ascending order.
