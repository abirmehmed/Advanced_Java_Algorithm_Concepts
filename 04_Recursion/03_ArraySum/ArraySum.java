public class ArraySum {
    public static int sumArray(int[] arr, int n) {
        // base case: if n becomes 0, return 0
        if (n == 0) {
            return 0;
        }
        // recursive case: add the current element to the sum of the remaining elements
        return arr[n - 1] + sumArray(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int sum = sumArray(array, array.length);
        System.out.println("Sum of array elements: " + sum);
    }
}
