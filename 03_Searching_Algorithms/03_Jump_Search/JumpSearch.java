public class JumpSearch {
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;
        
        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            
            if (prev >= n) {
                return -1; // If the target element is not found, return -1
            }
        }
        
        while (arr[prev] < target) {
            prev++;
            
            if (prev == Math.min(step, n)) {
                return -1; // If the target element is not found, return -1
            }
        }
        
        if (arr[prev] == target) {
            return prev; // Return the index of the target element
        }
        
        return -1; // If the target element is not found, return -1
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 20, 25, 30};
        int target = 20;
        
        int index = jumpSearch(arr, target);
        
        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }
    }
}
