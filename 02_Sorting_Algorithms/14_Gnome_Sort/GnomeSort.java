public class GnomeSort {
    public static void gnomeSort(int[] arr) {
        int n = arr.length;
        int index = 0;
        
        while (index < n) {
            if (index == 0) {
                index++;
            }
            
            if (arr[index] >= arr[index - 1]) {
                index++;
            } else {
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {9, 1, 5, 3, 2};
        gnomeSort(arr);
        
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
