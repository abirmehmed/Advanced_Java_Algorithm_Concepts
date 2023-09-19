
```java
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 12, 1, 6};
        bubbleSort(arr);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

#### Explanation of the Code:

The code above implements the bubble sort algorithm, which is a simple sorting algorithm. Here's how it works:

1. The `bubbleSort` method takes an array of integers as input and sorts it in ascending order using the bubble sort algorithm.

2. The outer loop `for (int i = 0; i < n - 1; i++)` runs `n-1` times, where `n` is the length of the array. It represents the number of passes needed to sort the array.

3. The inner loop `for (int j = 0; j < n - i - 1; j++)` runs from the first element to the `n-i-1` element of the array. It compares adjacent elements and swaps them if they are in the wrong order.

4. Inside the inner loop, the condition `if (arr[j] > arr[j + 1])` checks if the current element is greater than the next element. If it is, the two elements are swapped using a temporary variable `temp`.

5. After the inner loop completes, the largest element is guaranteed to be at the end of the array. The outer loop then moves to the next pass, and the process continues until the array is fully sorted.

6. In the `main` method, an example array `{5, 2, 8, 12, 1, 6}` is created. The `bubbleSort` method is called to sort the array in ascending order.

7. Finally, the sorted array is printed using a `for-each` loop.

The output of the above code will be:
```
Sorted array:
1 2 5 6 8 12
```

That's it! The code implements the bubble sort algorithm in Java to sort an array of integers in ascending order.
