public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;
        
        // Start with a large gap, then reduce the gap in each iteration
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Perform insertion sort on elements with the current gap
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                
                // Shift elements that are greater than the current value to the right
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                
                // Place the current value in its correct position
                arr[j] = temp;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {12, 9, 4, 7, 2, 10};
        shellSort(arr);
        
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
