#
Counting Sort: Implement the counting sort algorithm to sort an array of integers in ascending order.
#

```java
public class CountingSort {
    public static void countingSort(int[] arr) {
        int max = getMaxValue(arr);
        int[] count = new int[max + 1];

        for (int num : arr) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    public static int getMaxValue(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 12, 1, 6};
        countingSort(arr);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

#### Explanation of the Code:

The code above implements the counting sort algorithm, which is a non-comparison based sorting algorithm. Here's how it works:

1. The `countingSort` method takes an array of integers as input and sorts it in ascending order using the counting sort algorithm.

2. It starts by finding the maximum value in the input array using the `getMaxValue` method.

3. It creates an auxiliary array `count` of size `max + 1` to store the count of each element in the input array.

4. It then iterates through the input array and increments the count of each element in the `count` array.

5. After counting the occurrences of each element, it iterates through the `count` array and reconstructs the sorted array by placing each element in the correct position.

6. The `index` variable keeps track of the current index in the sorted array.

7. For each element `i` in the `count` array, it checks if the count is greater than 0.

8. If the count is greater than 0, it adds the element `i` to the sorted array `arr` and decrements the count.

9. This process is repeated until the count for the current element becomes 0.

10. In the `main` method, an example array `{5, 2, 8, 12, 1, 6}` is created. The `countingSort` method is called to sort the array in ascending order.

11. Finally, the sorted array is printed using a `for-each` loop.

The output of the above code will be:
```
Sorted array:
1 2 5 6 8 12
```

That's it! The code implements the counting sort algorithm in Java to sort an array of integers in ascending order.
