public class ExponentialSearch {
    public static int exponentialSearch(int[] arr, int target) {
        // If the target element is the first element in the array
        if (arr[0] == target) {
            return 0;
        }

        // Find the range for binary search
        int i = 1;
        while (i < arr.length && arr[i] <= target) {
            i *= 2;
        }

        // Perform binary search within the determined range
        int left = i / 2;
        int right = Math.min(i, arr.length - 1);

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // If the target element is not found, return -1
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
        int target = 12;

        int index = exponentialSearch(arr, target);

        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }
    }
}
