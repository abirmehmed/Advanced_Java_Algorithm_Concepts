public class PancakeSort {
    public static void pancakeSort(int[] arr) {
        int n = arr.length;
        
        for (int i = n - 1; i >= 0; i--) {
            int maxIndex = findMaxIndex(arr, i);
            
            if (maxIndex != i) {
                flip(arr, maxIndex);
                flip(arr, i);
            }
        }
    }
    
    private static int findMaxIndex(int[] arr, int end) {
        int maxIndex = 0;
        
        for (int i = 1; i <= end; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        
        return maxIndex;
    }
    
    private static void flip(int[] arr, int end) {
        int start = 0;
        
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {9, 1, 5, 3, 2};
        pancakeSort(arr);
        
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
