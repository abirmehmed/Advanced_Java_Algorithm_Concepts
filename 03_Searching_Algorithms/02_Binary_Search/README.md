#
Binary Search: Implement the binary search algorithm to find a target element in a sorted array.
#

```java
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid; // Return the index of the target element
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
        int[] arr = {5, 10, 15, 20, 25, 30};
        int target = 20;
        
        int index = binarySearch(arr, target);
        
        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }
    }
}
```

#### Explanation of the Code:

The code above implements the Binary Search algorithm, which is an efficient searching algorithm for sorted arrays. Here's how it works:

1. The `binarySearch` method takes a sorted array of integers (`arr`) and a target element (`target`) as input and returns the index of the target element if found, or -1 if not found.

2. It initializes two pointers, `left` and `right`, to the start and end indices of the array, respectively.

3. It enters a while loop that continues as long as the `left` pointer is less than or equal to the `right` pointer.

4. Inside the loop, it calculates the middle index `mid` as the average of the `left` and `right` indices.

5. It checks if the element at the middle index (`arr[mid]`) is equal to the target element. If they are equal, it means the target element is found, so the method returns the index `mid`.

6. If the element at the middle index is less than the target element, it means the target element must be in the right half of the array. So, the `left` pointer is updated to `mid + 1`.

7. If the element at the middle index is greater than the target element, it means the target element must be in the left half of the array. So, the `right` pointer is updated to `mid - 1`.

8. The loop continues until the target element is found or until the `left` pointer becomes greater than the `right` pointer, indicating that the target element is not present in the array.

9. If the loop completes without finding the target element, the method returns -1 to indicate that the target element is not present in the array.

10. In the `main` method, an example sorted array `{5, 10, 15, 20, 25, 30}` is created, and the target element is set to 20.

11. The `binarySearch` method is called with the array and target element as arguments, and the returned index is stored in the `index` variable.

12. If the returned index is not -1, it means the target element is found, so a message is printed indicating the index where the element is found. Otherwise, a message is printed indicating that the element is not found in the array.

The output of the above code will be:
```
Element found at index 3
```

That's it! The code implements the Binary Search algorithm in Java to find a target element in a sorted array.
