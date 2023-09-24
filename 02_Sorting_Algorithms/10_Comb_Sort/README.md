#
Comb Sort: Implement the comb sort algorithm to sort an array of integers in ascending order.
#

```java
public class CombSort {
    public static void combSort(int[] arr) {
        int n = arr.length;
        int gap = n;
        double shrink = 1.3;
        boolean swapped = true;
        
        while (gap > 1 || swapped) {
            // Calculate the gap size
            gap = (int) (gap / shrink);
            if (gap < 1) {
                gap = 1;
            }
            
            swapped = false;
            
            // Compare elements with the calculated gap
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    // Swap the elements
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    
                    swapped = true;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {12, 9, 4, 7, 2, 10};
        combSort(arr);
        
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

#### Explanation of the Code:

The code above implements the Comb Sort algorithm, which is a variant of the Bubble Sort algorithm. Here's how it works:

1. The `combSort` method takes an array of integers as input and sorts it in ascending order using the Comb Sort algorithm.

2. It starts by initializing the gap size to the length of the array (`n`). The gap size is then reduced by a shrink factor of 1.3 in each iteration until it becomes 1.

3. The algorithm compares elements that are `gap` distance apart and swaps them if they are out of order. This process is repeated for all elements in the array.

4. The `swapped` flag is used to keep track of whether any swaps were made in the current iteration. If no swaps were made, it means that the array is already sorted, and the algorithm terminates.

5. Finally, the sorted array is printed using a `for-each` loop.

In the `main` method, an example array `{12, 9, 4, 7, 2, 10}` is created. The `combSort` method is called to sort the array in ascending order.

The output of the above code will be:
```
Sorted array:
2 4 7 9 10 12
```

That's it! The code implements the Comb Sort algorithm in Java to sort an array of integers in ascending order.
