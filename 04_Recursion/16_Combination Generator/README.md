#
Combination Generator: Write a recursive function to generate all combinations of a given set of elements.
#

```java
import java.util.ArrayList;
import java.util.List;

public class CombinationGenerator {
    public static List<List<Integer>> generateCombinations(int[] nums) {
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinations(nums, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void generateCombinations(int[] nums, int index, List<Integer> current, List<List<Integer>> combinations) {
        combinations.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateCombinations(nums, i + 1, current, combinations);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> combinations = generateCombinations(nums);
        System.out.println("Combinations of the given set: ");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
```

In this code, the recursive function `generateCombinations` takes an array `nums` as input and returns a list of all possible combinations of the given set.

The function uses an additional helper function `generateCombinations` which takes the index, the current combination, and the list of combinations as parameters.

In the main function, we initialize an empty list `combinations` to store the combinations, and then call the `generateCombinations` function with the given set `nums`, starting from index 0 and an empty current combination.

The base case for the recursive function is when we have processed all the elements in the `nums` array. At each recursive call, we add the current combination to the list of combinations.

For each index starting from the given index, we add the element at that index to the current combination, recursively call the function with the next index, and then remove the added element from the current combination before moving on to the next index. This ensures that we generate all possible combinations.

In the `main` method, we call the `generateCombinations` function with a sample set `{1, 2, 3}` and print all the combinations.

When you run this code, it will output all the combinations of the given set:
```
Combinations of the given set: 
[]
[1]
[1, 2]
[1, 2, 3]
[1, 3]
[2]
[2, 3]
[3]
```

Each line represents a combination, with the empty combination represented by an empty list `[]`.
