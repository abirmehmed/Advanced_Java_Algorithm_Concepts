import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<String> generatePermutations(String str) {
        List<String> permutations = new ArrayList<>();
        generatePermutationsHelper(str.toCharArray(), 0, permutations);
        return permutations;
    }

    private static void generatePermutationsHelper(char[] strArray, int currentIndex, List<String> permutations) {
        if (currentIndex == strArray.length - 1) {
            permutations.add(String.valueOf(strArray));
        } else {
            for (int i = currentIndex; i < strArray.length; i++) {
                swap(strArray, currentIndex, i);
                generatePermutationsHelper(strArray, currentIndex + 1, permutations);
                swap(strArray, currentIndex, i);
            }
        }
    }

    private static void swap(char[] strArray, int i, int j) {
        char temp = strArray[i];
        strArray[i] = strArray[j];
        strArray[j] = temp;
    }

    public static void main(String[] args) {
        String str = "abc";
        List<String> permutations = generatePermutations(str);
        System.out.println("Permutations of " + str + ":");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
