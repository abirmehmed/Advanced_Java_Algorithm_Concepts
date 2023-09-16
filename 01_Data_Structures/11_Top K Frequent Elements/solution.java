import java.util.*;

public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each number using a HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a PriorityQueue to store the k most frequent elements
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(frequencyMap::get));

        // Step 3: Iterate through the frequency map
        for (int num : frequencyMap.keySet()) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Build the result list from the PriorityQueue
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(0, pq.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        Solution solution = new Solution();
        List<Integer> result = solution.topKFrequent(nums, k);

        System.out.println("Top " + k + " frequent elements: " + result);
    }
}
