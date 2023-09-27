public class CycleSort {
    public static void cycleSort(int[] arr) {
        int n = arr.length;
        
        for (int cycleStart = 0; cycleStart < n - 1; cycleStart++) {
            int item = arr[cycleStart];
            int pos = cycleStart;
            
            // Find the correct position for the current element
            for (int i = cycleStart + 1; i < n; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }
            
            // If the current element is already in the correct position, move to the next element
            if (pos == cycleStart) {
                continue;
            }
            
            // Move the elements to create a cycle
            while (item == arr[pos]) {
                pos++;
            }
            
            int temp = arr[pos];
            arr[pos] = item;
            
            // Rotate the rest of the cycle
            while (pos != cycleStart) {
                pos = cycleStart;
                
                // Find the correct position for the current element
                for (int i = cycleStart + 1; i < n; i++) {
                    if (arr[i] < temp) {
                        pos++;
                    }
                }
                
                // Move the elements to create a cycle
                while (temp == arr[pos]) {
                    pos++;
                }
                
                // Swap the elements
                int temp2 = arr[pos];
                arr[pos] = temp;
                temp = temp2;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {9, 1, 5, 3, 2};
        cycleSort(arr);
        
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
