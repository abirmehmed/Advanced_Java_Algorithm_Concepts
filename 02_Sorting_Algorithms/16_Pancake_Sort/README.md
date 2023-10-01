#
Pancake Sort: Implement the pancake sort algorithm to sort an array of integers in ascending order.
#

```java
public class PancakeSort {
    public static void pancakeSort(int[] arr) {
        int n = arr.length;
        
        for (int i = n - 1; i >= 0; i--) {
            int maxIndex = findMaxIndex(arr, i);
            
            if (maxIndex != i) {
                flip(arr, maxIndex);
                flip(arr, i);
            }
        }
    }
    
    private static int findMaxIndex(int[] arr, int end) {
        int maxIndex = 0;
        
        for (int i = 1; i <= end; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        
        return maxIndex;
    }
    
    private static void flip(int[] arr, int end) {
        int start = 0;
        
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {9, 1, 5, 3, 2};
        pancakeSort(arr);
        
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

#### Explanation of the Code:

The code above implements the Pancake Sort algorithm, which is a variation of the Selection Sort algorithm. Here's how it works:

1. The `pancakeSort` method takes an array of integers as input and sorts it in ascending order using the Pancake Sort algorithm.

2. It uses a for loop that starts from the last index of the array (`i` starts from `n - 1`) and goes backward until the first index.

3. In each iteration of the loop, the `findMaxIndex` method is called to find the index of the maximum element in the unsorted portion of the array (`i` to 0).

4. If the maximum element is not already at the current position (`maxIndex != i`), the `flip` method is called twice. The first call flips the subarray from the first element to the maximum element, bringing the maximum element to the first position. The second call flips the subarray from the first element to the current position, bringing the maximum element to its correct position in the sorted portion of the array.

5. The process is repeated for each position in the array, gradually sorting the entire array.

6. The `findMaxIndex` method finds the index of the maximum element in the array from index 0 to the given `end` index. It starts with the assumption that the maximum element is at index 0 and updates the `maxIndex` if a larger element is found.

7. The `flip` method takes an array and an `end` index as input and flips the subarray from index 0 to the `end` index. It uses two pointers (`start` and `end`) that move towards each other, swapping elements until they meet in the middle.

8. In the `main` method, an example array `{9, 1, 5, 3, 2}` is created. The `pancakeSort` method is called to sort the array in ascending order.

The output of the above code will be:
```
Sorted array:
1 2 3 5 9
```

That's it! The code implements the Pancake Sort algorithm in Java to sort an array of integers in ascending order.
