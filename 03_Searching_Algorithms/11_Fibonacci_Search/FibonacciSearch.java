public class FibonacciSearch {
    public static int fibonacciSearch(int[] arr, int target) {
        int n = arr.length;
        
        // Generate the Fibonacci series
        int fib2 = 0; // Second Fibonacci number
        int fib1 = 1; // First Fibonacci number
        int fib = fib2 + fib1; // Next Fibonacci number

        while (fib < n) {
            fib2 = fib1;
            fib1 = fib;
            fib = fib2 + fib1;
        }

        int offset = -1; // Offset to keep track of the eliminated range

        while (fib > 1) {
            int i = Math.min(offset + fib2, n - 1);

            if (arr[i] == target) {
                return i; // Found target at index i
            } else if (arr[i] < target) {
                fib = fib1;
                fib1 = fib2;
                fib2 = fib - fib1;
                offset = i;
            } else {
                fib = fib2;
                fib1 = fib1 - fib2;
                fib2 = fib - fib1;
            }
        }

        if (fib1 == 1 && arr[offset + 1] == target) {
            return offset + 1; // Found target at index offset + 1
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 9;

        int result = fibonacciSearch(arr, target);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + result);
        }
    }
}
