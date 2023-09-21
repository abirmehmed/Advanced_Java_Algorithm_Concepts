#
Merge Sort: Implement the merge sort algorithm to sort an array of integers in ascending order.
#

```java
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 12, 1, 6};
        mergeSort(arr);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

#### Explanation of the Code:

The code above implements the merge sort algorithm, which is a divide-and-conquer algorithm. Here's how it works:

1. The `mergeSort` method takes an array of integers as input and sorts it in ascending order using the merge sort algorithm.

2. The base case is when the length of the array is less than or equal to 1. In this case, the array is already sorted, so we return.

3. If the base case is not met, we find the middle index `mid` of the array.

4. We create two new arrays, `left` and `right`, of sizes `mid` and `arr.length - mid` respectively.

5. We use `System.arraycopy` to copy the elements from the original array into the `left` and `right` arrays.

6. We recursively call `mergeSort` on the `left` and `right` arrays to sort them.

7. We then call the `merge` method to merge the sorted `left` and `right` arrays into the original array.

8. The `merge` method takes three arrays as input: `left`, `right`, and `arr`. It merges the elements from `left` and `right` arrays into `arr` in ascending order.

9. We use three pointers, `i`, `j`, and `k`, to iterate through the `left`, `right`, and `arr` arrays respectively.

10. We compare the elements at `left[i]` and `right[j]`. If `left[i]` is smaller or equal, we assign it to `arr[k]` and increment `i`. Otherwise, we assign `right[j]` to `arr[k]` and increment `j`.

11. We increment `k` after assigning an element to `arr`.

12. After one of the arrays is exhausted, we copy the remaining elements from the other array into `arr`.

13. In the `main` method, an example array `{5, 2, 8, 12, 1, 6}` is created. The `mergeSort` method is called to sort the array in ascending order.

14. Finally, the sorted array is printed using a `for-each` loop.

The output of the above code will be:
```
Sorted array:
1 2 5 6 8 12
```

That's it! The code implements the merge sort algorithm in Java to sort an array of integers in ascending order.
