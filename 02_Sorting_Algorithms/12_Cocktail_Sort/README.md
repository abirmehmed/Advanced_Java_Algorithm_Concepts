
```java
public class CocktailSort {
    public static void cocktailSort(int[] arr) {
        boolean swapped;
        do {
            swapped = false;
            
            // Perform a bubble sort from left to right
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    // Swap arr[i] and arr[i + 1]
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            
            if (!swapped) {
                break;
            }
            
            swapped = false;
            
            // Perform a bubble sort from right to left
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] > arr[i + 1]) {
                    // Swap arr[i] and arr[i + 1]
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
    
    public static void main(String[] args) {
        int[] arr = {12, 9, 4, 7, 2, 10};
        cocktailSort(arr);
        
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

#### Explanation of the Code:

The code above implements the Cocktail Sort algorithm, which is a variation of the Bubble Sort algorithm. Here's how it works:

1. The `cocktailSort` method takes an array of integers as input and sorts it in ascending order using the Cocktail Sort algorithm.

2. It uses a `do-while` loop to repeat the sorting process until no more swaps are needed. The variable `swapped` is used to keep track of whether any swaps were made in the current iteration.

3. The algorithm starts by performing a bubble sort from left to right. It compares adjacent elements and swaps them if they are in the wrong order.

4. After completing the first pass from left to right, the algorithm checks if any swaps were made. If no swaps were made, it means that the array is already sorted and the algorithm can exit.

5. If swaps were made, the algorithm performs a bubble sort from right to left. It compares adjacent elements in the opposite order and swaps them if needed.

6. The process is repeated until no more swaps are made in either direction, indicating that the array is sorted.

7. Finally, the sorted array is printed using a `for-each` loop.

In the `main` method, an example array `{12, 9, 4, 7, 2, 10}` is created. The `cocktailSort` method is called to sort the array in ascending order.

The output of the above code will be:
```
Sorted array:
2 4 7 9 10 12
```

That's it! The code implements the Cocktail Sort algorithm in Java to sort an array of integers in ascending order.
