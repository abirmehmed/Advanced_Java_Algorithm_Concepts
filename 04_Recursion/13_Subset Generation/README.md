

```java
import java.util.ArrayList;
import java.util.List;

public class SubsetGeneration {
    public static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private static void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsets(nums, i + 1, current, subsets);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = generateSubsets(nums);
        System.out.println("Subsets of the given set: ");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
```

In this code, the recursive function `generateSubsets` takes an array `nums` as input and returns a list of all possible subsets of the given set.

The function uses an additional helper function `generateSubsets` which takes the index, the current subset, and the list of subsets as parameters.

In the main function, we initialize an empty list `subsets` to store the subsets, and then call the `generateSubsets` function with the given set `nums`, starting from index 0 and an empty current subset.

The base case for the recursive function is when we have processed all the elements in the `nums` array. At each recursive call, we add the current subset to the list of subsets.

For each index starting from the given index, we add the element at that index to the current subset, recursively call the function with the next index, and then remove the added element from the current subset before moving on to the next index. This ensures that we generate all possible subsets.

In the `main` method, we call the `generateSubsets` function with a sample set `{1, 2, 3}` and print all the subsets.

When you run this code, it will output all the subsets of the given set:
```
Subsets of the given set: 
[]
[1]
[1, 2]
[1, 2, 3]
[1, 3]
[2]
[2, 3]
[3]
```

Each line represents a subset, with the empty subset represented by an empty list `[]`.
