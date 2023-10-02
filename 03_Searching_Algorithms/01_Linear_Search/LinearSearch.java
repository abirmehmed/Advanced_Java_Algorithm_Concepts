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
