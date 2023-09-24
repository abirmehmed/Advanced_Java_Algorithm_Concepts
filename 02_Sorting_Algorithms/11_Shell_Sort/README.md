#
Shell Sort: Implement the shell sort algorithm to sort an array of integers in ascending order.
#

```java
public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;
        
        // Start with a large gap, then reduce the gap in each iteration
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Perform insertion sort on elements with the current gap
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                
                // Shift elements that are greater than the current value to the right
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                
                // Place the current value in its correct position
                arr[j] = temp;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {12, 9, 4, 7, 2, 10};
        shellSort(arr);
        
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

#### Explanation of the Code:

The code above implements the Shell Sort algorithm, which is an optimization of the Insertion Sort algorithm. Here's how it works:

1. The `shellSort` method takes an array of integers as input and sorts it in ascending order using the Shell Sort algorithm.

2. It starts with a large gap size (`n/2`), then reduces the gap size in each iteration by dividing it by 2.

3. For each gap size, the algorithm performs an insertion sort on the elements with that gap. It considers elements at positions `gap`, `gap * 2`, `gap * 3`, and so on.

4. In the insertion sort step, it takes the current element and compares it with the elements `gap` positions behind it. If the current element is smaller, it shifts the larger elements to the right to make space for the current element.

5. Finally, the sorted array is printed using a `for-each` loop.

In the `main` method, an example array `{12, 9, 4, 7, 2, 10}` is created. The `shellSort` method is called to sort the array in ascending order.

The output of the above code will be:
```
Sorted array:
2 4 7 9 10 12
```

That's it! The code implements the Shell Sort algorithm in Java to sort an array of integers in ascending order.
