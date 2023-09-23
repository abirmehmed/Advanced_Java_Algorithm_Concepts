#
Heap Sort: Implement the heap sort algorithm to sort an array of integers in ascending order.
#

```java
public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;
        
        // Build max heap
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }
    
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;     // Initialize largest as root
        int left = 2 * i + 1;    // Left child
        int right = 2 * i + 2;   // Right child
        
        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        // If largest is not the root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        heapSort(arr);
        
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

#### Explanation of the Code:

The code above implements the heap sort algorithm, which is a comparison-based sorting algorithm that uses a binary heap data structure. Here's how it works:

1. The `heapSort` method takes an array of integers as input and sorts it in ascending order using the heap sort algorithm.

2. It starts by building a max heap from the input array. This is done by repeatedly calling the `heapify` method on each non-leaf node starting from the last non-leaf node and moving upwards.

3. The `heapify` method takes an array, the size of the heap, and the index of the current node as input. It compares the element at the current node with its left and right children to find the largest element among them. If the largest element is not the current node, it swaps the elements and recursively calls `heapify` on the affected sub-tree.

4. Once the max heap is built, the largest element (root) is at the top of the heap. The `heapSort` method repeatedly extracts the largest element from the heap by swapping it with the last element, reducing the heap size by one, and then heapifying the reduced heap.

5. Finally, the sorted array is printed using a `for-each` loop.

In the `main` method, an example array `{12, 11, 13, 5, 6, 7}` is created. The `heapSort` method is called to sort the array in ascending order.

The output of the above code will be:
```
Sorted array:
5 6 7 11 12 13
```

That's it! The code implements the heap sort algorithm in Java to sort an array of integers in ascending order.
