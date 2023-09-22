import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void bucketSort(float[] arr) {
        int n = arr.length;
        
        // Create empty buckets
        List<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        // Add elements to the buckets
        for (float num : arr) {
            int bucketIndex = (int) (n * num);
            buckets[bucketIndex].add(num);
        }
        
        // Sort each bucket
        for (List<Float> bucket : buckets) {
            Collections.sort(bucket);
        }
        
        // Concatenate the sorted buckets
        int index = 0;
        for (List<Float> bucket : buckets) {
            for (float num : bucket) {
                arr[index++] = num;
            }
        }
    }
    
    public static void main(String[] args) {
        float[] arr = {0.42f, 0.32f, 0.33f, 0.52f, 0.37f, 0.47f, 0.51f};
        bucketSort(arr);
        
        System.out.println("Sorted array:");
        for (float num : arr) {
            System.out.print(num + " ");
        }
    }
}
