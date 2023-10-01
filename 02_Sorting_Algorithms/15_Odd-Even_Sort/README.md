#
Odd-Even Sort: Implement the odd-even sort algorithm to sort an array of integers in ascending order.
#

```java
public class OddEvenSort {
    public static void oddEvenSort(int[] arr) {
        int n = arr.length;
        boolean isSorted = false;
        
        while (!isSorted) {
            isSorted = true;
            
            // Perform odd-even comparisons and swaps
            for (int i = 1; i < n - 1; i += 2) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                }
            }
            
            // Perform even-odd comparisons and swaps
            for (int i = 0; i < n - 1; i += 2) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {9, 1, 5, 3, 2};
        oddEvenSort(arr);
        
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

#### Explanation of the Code:

The code above implements the Odd-Even Sort algorithm, also known as the Brick Sort algorithm. Here's how it works:

1. The `oddEvenSort` method takes an array of integers as input and sorts it in ascending order using the Odd-Even Sort algorithm.

2. It uses a while loop to repeat the sorting process until the array is fully sorted. The loop continues until the variable `isSorted` is true.

3. Inside the loop, there are two nested for loops. The first loop compares and swaps adjacent elements with odd indices (`i` starts from 1 and increments by 2). The second loop compares and swaps adjacent elements with even indices (`i` starts from 0 and increments by 2).

4. If any element is found to be out of order and a swap is performed, the variable `isSorted` is set to false, indicating that the array is not fully sorted yet.

5. The algorithm continues this process until no more swaps are needed, indicating that the array is fully sorted.

6. Finally, the sorted array is printed using a `for-each` loop in the `main` method.

In the `main` method, an example array `{9, 1, 5, 3, 2}` is created. The `oddEvenSort` method is called to sort the array in ascending order.

The output of the above code will be:
```
Sorted array:
1 2 3 5 9
```

That's it! The code implements the Odd-Even Sort algorithm in Java to sort an array of integers in ascending order.
