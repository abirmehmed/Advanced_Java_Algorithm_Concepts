
```java
public class QuickSort {
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 12, 1, 6};
        quickSort(arr);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

#### Explanation of the Code:

The code above implements the quick sort algorithm, which is a divide-and-conquer algorithm. Here's how it works:

1. The `quickSort` method takes an array of integers as input and sorts it in ascending order using the quick sort algorithm.

2. The base case is when `low` is less than `high`. In this case, we need to partition the array and recursively sort the two partitions.

3. The `partition` method takes three parameters: `arr`, `low`, and `high`. It selects the last element of the array, `arr[high]`, as the pivot.

4. We initialize `i` to `low - 1` and iterate through the array from `low` to `high - 1`.

5. If an element `arr[j]` is less than the pivot, we increment `i` and swap `arr[i]` with `arr[j]`.

6. After the loop, we swap the pivot element `arr[high]` with `arr[i + 1]` to place the pivot in its correct position.

7. The `swap` method is used to swap two elements in the array.

8. We recursively call `quickSort` on the two partitions: from `low` to `pivotIndex - 1` and from `pivotIndex + 1` to `high`.

9. In the `main` method, an example array `{5, 2, 8, 12, 1, 6}` is created. The `quickSort` method is called to sort the array in ascending order.

10. Finally, the sorted array is printed using a `for-each` loop.

The output of the above code will be:
```
Sorted array:
1 2 5 6 8 12
```

That's it! The code implements the quick sort algorithm in Java to sort an array of integers in ascending order.
