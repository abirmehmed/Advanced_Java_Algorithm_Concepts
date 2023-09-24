public class CombSort {
    public static void combSort(int[] arr) {
        int n = arr.length;
        int gap = n;
        double shrink = 1.3;
        boolean swapped = true;
        
        while (gap > 1 || swapped) {
            // Calculate the gap size
            gap = (int) (gap / shrink);
            if (gap < 1) {
                gap = 1;
            }
            
            swapped = false;
            
            // Compare elements with the calculated gap
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    // Swap the elements
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    
                    swapped = true;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {12, 9, 4, 7, 2, 10};
        combSort(arr);
        
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
