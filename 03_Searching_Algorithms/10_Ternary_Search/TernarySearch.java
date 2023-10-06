public class TernarySearch {
    public static int ternarySearch(int[] arr, int target) {
        int left = 0; // left pointer
        int right = arr.length - 1; // right pointer

        while (left <= right) {
            int mid1 = left + (right - left) / 3; // calculate the first mid
            int mid2 = right - (right - left) / 3; // calculate the second mid

            if (arr[mid1] == target) {
                return mid1; // found target at mid1
            }

            if (arr[mid2] == target) {
                return mid2; // found target at mid2
            }

            if (target < arr[mid1]) {
                right = mid1 - 1; // search the left third
            } else if (target > arr[mid2]) {
                left = mid2 + 1; // search the right third
            } else {
                left = mid1 + 1; // search the middle third
                right = mid2 - 1;
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 9;

        int result = ternarySearch(arr, target);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + result);
        }
    }
}
