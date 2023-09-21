
```java
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 12, 1, 6};
        insertionSort(arr);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

#### Explanation of the Code:

The code above implements the insertion sort algorithm, which is another simple sorting algorithm. Here's how it works:

1. The `insertionSort` method takes an array of integers as input and sorts it in ascending order using the insertion sort algorithm.

2. The outer loop `for (int i = 1; i < n; i++)` starts from the second element (index 1) and goes up to the last element (index `n-1`). It represents the portion of the array that is already sorted.

3. Inside the outer loop, we store the current element at index `i` in the variable `key`.

4. We initialize a variable `j` to `i - 1`. This variable represents the index of the last element in the sorted portion of the array.

5. We enter a while loop `while (j >= 0 && arr[j] > key)` that continues as long as `j` is not negative and the element at index `j` is greater than the `key`.

6. Inside the while loop, we shift the elements greater than `key` one position to the right. This is done by assigning `arr[j + 1] = arr[j]`.

7. We decrement `j` by 1 to move to the previous element in the sorted portion of the array.

8. After the while loop completes, we have found the correct position for `key`. We assign `key` to `arr[j + 1]`.

9. The process continues until the entire array is sorted.

10. In the `main` method, an example array `{5, 2, 8, 12, 1, 6}` is created. The `insertionSort` method is called to sort the array in ascending order.

11. Finally, the sorted array is printed using a `for-each` loop.

The output of the above code will be:
```
Sorted array:
1 2 5 6 8 12
```

That's it! The code implements the insertion sort algorithm in Java to sort an array of integers in ascending order.
