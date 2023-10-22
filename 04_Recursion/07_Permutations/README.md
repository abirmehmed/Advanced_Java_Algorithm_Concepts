Certainly! Here's an example of a recursive function in Java to generate all permutations of a given string:

```java
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
```

In this code, the `generatePermutations` function takes a string `str` as input and returns a list of all permutations of the string.

The function initializes an empty list `permutations` to store the permutations. It then calls the recursive helper function `generatePermutationsHelper`, passing in the string converted to a character array, the current index (initialized as 0), and the permutations list.

The `generatePermutationsHelper` function is a recursive function that uses backtracking to generate all permutations. It takes the character array, the current index, and the permutations list as input. 

The base case is when the current index reaches the last index of the array. In this case, it converts the character array to a string and adds it to the permutations list.

In the recursive case, it iterates over the characters starting from the current index. For each character, it swaps it with the character at the current index, then recursively calls itself with the updated character array and the next index. After the recursive call, it swaps the characters back to restore the original order, which is necessary for generating all permutations.

The `swap` function is a helper function that swaps two characters in the character array.

The `main` function demonstrates the usage of the `generatePermutations` function by generating all permutations of the string "abc" and printing them.
