public class BinarySearch {
    public static int binarySearch(int[] arr, int target, int low, int high) {
        // base case: if low becomes greater than high, the target is not found
        if (low > high) {
            return -1;
        }
        
        // calculate the middle index
        int mid = low + (high - low) / 2;
        
        // if the middle element is the target, return the index
        if (arr[mid] == target) {
            return mid;
        }
        
        // if the target is less than the middle element, search the left half
        if (target < arr[mid]) {
            return binarySearch(arr, target, low, mid - 1);
        }
        
        // if the target is greater than the middle element, search the right half
        return binarySearch(arr, target, mid + 1, high);
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11};
        int target = 7;
        int index = binarySearch(array, target, 0, array.length - 1);
        if (index != -1) {
            System.out.println("Target element found at index " + index);
        } else {
            System.out.println("Target element not found in the array.");
        }
    }
}
