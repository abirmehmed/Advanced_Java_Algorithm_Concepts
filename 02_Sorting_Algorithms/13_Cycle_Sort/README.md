#
Cycle Sort: Implement the cycle sort algorithm to sort an array of integers in ascending order.
#

```java
public class CycleSort {
    public static void cycleSort(int[] arr) {
        int n = arr.length;
        
        for (int cycleStart = 0; cycleStart < n - 1; cycleStart++) {
            int item = arr[cycleStart];
            int pos = cycleStart;
            
            // Find the correct position for the current element
            for (int i = cycleStart + 1; i < n; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }
            
            // If the current element is already in the correct position, move to the next element
            if (pos == cycleStart) {
                continue;
            }
            
            // Move the elements to create a cycle
            while (item == arr[pos]) {
                pos++;
            }
            
            int temp = arr[pos];
            arr[pos] = item;
            
            // Rotate the rest of the cycle
            while (pos != cycleStart) {
                pos = cycleStart;
                
                // Find the correct position for the current element
                for (int i = cycleStart + 1; i < n; i++) {
                    if (arr[i] < temp) {
                        pos++;
                    }
                }
                
                // Move the elements to create a cycle
                while (temp == arr[pos]) {
                    pos++;
                }
                
                // Swap the elements
                int temp2 = arr[pos];
                arr[pos] = temp;
                temp = temp2;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {9, 1, 5, 3, 2};
        cycleSort(arr);
        
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

#### Explanation of the Code:

The code above implements the Cycle Sort algorithm, which is an in-place sorting algorithm. Here's how it works:

1. The `cycleSort` method takes an array of integers as input and sorts it in ascending order using the Cycle Sort algorithm.

2. It uses two nested loops to iterate over the array. The outer loop (`cycleStart`) determines the starting position of each cycle, while the inner loop (`i`) finds the correct position for the current element.

3. For each cycle, the algorithm selects an element (`item`) from the current cycle start position (`cycleStart`) and finds the correct position (`pos`) for it by counting the number of elements smaller than `item`.

4. If the current element is already in the correct position, the algorithm moves to the next element.

5. If the current element is not in the correct position, the algorithm moves the elements to create a cycle. It finds the next position (`pos`) where the current element should be placed, and swaps the elements until the current element is placed in its correct position.

6. The algorithm repeats this process for all cycles until the array is sorted.

7. Finally, the sorted array is printed using a `for-each` loop in the `main` method.

In the `main` method, an example array `{9, 1, 5, 3, 2}` is created. The `cycleSort` method is called to sort the array in ascending order.

The output of the above code will be:
```
Sorted array:
1 2 3 5 9
```

That's it! The code implements the Cycle Sort algorithm in Java to sort an array of integers in ascending order.
