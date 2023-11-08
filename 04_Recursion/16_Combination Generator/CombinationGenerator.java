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
