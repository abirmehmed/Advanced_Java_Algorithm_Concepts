
```java
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void combinationSumHelper(int[] candidates, int target, int startIndex, List<Integer> currentCombination, List<List<Integer>> combinations) {
        if (target == 0) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                currentCombination.add(candidates[i]);
                combinationSumHelper(candidates, target - candidates[i], i, currentCombination, combinations);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = combinationSum(candidates, target);

        System.out.println("Combinations that sum up to " + target + ":");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
```

In this code, the `combinationSum` function takes an array of candidates, `target` sum, and returns a list of all combinations of numbers that sum up to the target.

The function initializes an empty list `combinations` to store the combinations. It then calls the recursive helper function `combinationSumHelper`, passing in the candidates array, target sum, starting index (initialized as 0), an empty list to store the current combination, and the combinations list.

The `combinationSumHelper` function is a recursive function that uses backtracking to find all combinations. It takes the candidates array, target sum, current index, current combination, and combinations list as input.

The base case is when the target sum reaches 0. In this case, it adds the current combination to the combinations list.

In the recursive case, it iterates over the candidates starting from the current index. For each candidate, if it is less than or equal to the remaining target sum, it adds the candidate to the current combination, recursively calls itself with the updated target sum and the same index (to allow for repeating candidates), and then removes the last added candidate to backtrack and explore other combinations.

The `main` function demonstrates the usage of the `combinationSum` function by finding all combinations of the candidates array `{2, 3, 6, 7}` that sum up to the target value of 7, and prints them.
