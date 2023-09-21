#
Radix Sort: Implement the radix sort algorithm to sort an array of integers in ascending order.
#

```java
public class RadixSort {
    public static void radixSort(int[] arr) {
        int max = getMaxValue(arr);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    public static void countingSortByDigit(int[] arr, int exp) {
        int[] output = new int[arr.length];
        int[] count = new int[10];

        for (int num : arr) {
            int digit = (num / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
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
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

#### Explanation of the Code:

The code above implements the radix sort algorithm, which is a non-comparison based sorting algorithm that sorts integers by processing the digits from the least significant digit to the most significant digit. Here's how it works:

1. The `radixSort` method takes an array of integers as input and sorts it in ascending order using the radix sort algorithm.

2. It starts by finding the maximum value in the input array using the `getMaxValue` method.

3. It then iterates through each digit position, starting from the least significant digit (exp = 1) and moving towards the most significant digit (exp *= 10).

4. For each digit position, it calls the `countingSortByDigit` method to sort the array based on that digit.

5. The `countingSortByDigit` method performs counting sort based on the current digit.

6. It creates an auxiliary array `output` of the same size as the input array to store the sorted elements.

7. It also creates an auxiliary array `count` of size 10 to store the count of each digit (0 to 9).

8. It iterates through the input array and calculates the digit of each element based on the current digit position using the formula `(num / exp) % 10`.

9. It increments the count of the corresponding digit in the `count` array.

10. It then performs a prefix sum on the `count` array to determine the correct positions of each digit.

11. It iterates through the input array in reverse order and places each element in the correct position in the `output` array based on the current digit.

12. After sorting all the elements based on the current digit, it copies the sorted elements from the `output` array back to the input array.

13. In the `main` method, an example array `{170, 45, 75, 90, 802, 24, 2, 66}` is created. The `radixSort` method is called to sort the array in ascending order.

14. Finally, the sorted array is printed using a `for-each` loop.

The output of the above code will be:
```
Sorted array:
2 24 45 66 75 90 170 802
```

That's it! The code implements the radix sort algorithm in Java to sort an array of integers in ascending order.
