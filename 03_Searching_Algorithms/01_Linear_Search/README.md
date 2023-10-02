

```java
public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index of the target element
            }
        }
        
        return -1; // If the target element is not found, return -1
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 20, 25, 30};
        int target = 20;
        
        int index = linearSearch(arr, target);
        
        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }
    }
}
```

#### Explanation of the Code:

The code above implements the Linear Search algorithm, which is a simple searching algorithm that checks each element in a given array until it finds the target element or reaches the end of the array. Here's how it works:

1. The `linearSearch` method takes an array of integers (`arr`) and a target element (`target`) as input and returns the index of the target element if found, or -1 if not found.

2. It uses a for loop that iterates over each element of the array, starting from index 0 and going up to the last index (`i < arr.length`).

3. In each iteration of the loop, it checks if the current element (`arr[i]`) is equal to the target element. If they are equal, it means the target element is found, so the method returns the index `i`.

4. If the loop completes without finding the target element, the method returns -1 to indicate that the target element is not present in the array.

5. In the `main` method, an example array `{5, 10, 15, 20, 25, 30}` is created, and the target element is set to 20.

6. The `linearSearch` method is called with the array and target element as arguments, and the returned index is stored in the `index` variable.

7. If the returned index is not -1, it means the target element is found, so a message is printed indicating the index where the element is found. Otherwise, a message is printed indicating that the element is not found in the array.

The output of the above code will be:
```
Element found at index 3
```

That's it! The code implements the Linear Search algorithm in Java to find a target element in an array.
