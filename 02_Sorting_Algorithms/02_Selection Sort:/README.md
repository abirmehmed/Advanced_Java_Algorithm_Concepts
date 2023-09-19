


```java
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap arr[i] and arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 12, 1, 6};
        selectionSort(arr);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

#### Explanation of the Code:

The code above implements the selection sort algorithm, which is another simple sorting algorithm. Here's how it works:

1. The `selectionSort` method takes an array of integers as input and sorts it in ascending order using the selection sort algorithm.

2. The outer loop `for (int i = 0; i < n - 1; i++)` runs `n-1` times, where `n` is the length of the array. It represents the number of passes needed to sort the array.

3. Inside the outer loop, we initialize `minIndex` to `i`. This variable keeps track of the index of the smallest element found so far.

4. The inner loop `for (int j = i + 1; j < n; j++)` starts from `i+1` and compares each element with the current minimum element. If a smaller element is found, `minIndex` is updated.

5. After the inner loop completes, we have the index of the smallest element in the remaining unsorted portion of the array. We swap this element with the element at index `i` using a temporary variable `temp`.

6. The process continues until the entire array is sorted.

7. In the `main` method, an example array `{5, 2, 8, 12, 1, 6}` is created. The `selectionSort` method is called to sort the array in ascending order.

8. Finally, the sorted array is printed using a `for-each` loop.

The output of the above code will be:
```
Sorted array:
1 2 5 6 8 12
```

That's it! The code implements the selection sort algorithm in Java to sort an array of integers in ascending order.
