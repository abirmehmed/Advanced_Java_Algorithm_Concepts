
```java
public class BinarySearch {
    public static int binarySearch(int[] arr, int target, int low, int high) {
        // base case: if low becomes greater than high, the target is not found
        if (low > high) {
            return -1;
        }
        
        // calculate the middle index
        int mid = low + (high - low) / 2;
        
        // if the middle element is the target, return the index
        if (arr[mid] == target) {
            return mid;
        }
        
        // if the target is less than the middle element, search the left half
        if (target < arr[mid]) {
            return binarySearch(arr, target, low, mid - 1);
        }
        
        // if the target is greater than the middle element, search the right half
        return binarySearch(arr, target, mid + 1, high);
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11};
        int target = 7;
        int index = binarySearch(array, target, 0, array.length - 1);
        if (index != -1) {
            System.out.println("Target element found at index " + index);
        } else {
            System.out.println("Target element not found in the array.");
        }
    }
}
```

In this code, the `binarySearch` function takes a sorted array `arr`, a target value `target`, and the low and high indices of the search range as input. It performs binary search recursively to find the index of the target element in the array. 

The function first checks if the low index becomes greater than the high index, in which case the target is not found and -1 is returned. Otherwise, it calculates the middle index using the formula `(low + high) / 2`. If the middle element is equal to the target, it returns the middle index. If the target is less than the middle element, it recursively calls itself with the low index and the middle index minus one to search the left half of the array. If the target is greater than the middle element, it recursively calls itself with the middle index plus one and the high index to search the right half of the array.

The `main` function demonstrates the usage of the `binarySearch` function by performing binary search on a sorted array `{1, 3, 5, 7, 9, 11}` to find the target element 7. It then prints whether the target element is found or not, along with its index.
