#
Parenthesis Checker: Write a recursive function to check if a given string of parentheses is balanced. in java .
#

```java
public class ParenthesisChecker {
    public static boolean isBalanced(String str) {
        return isBalanced(str, 0, 0);
    }

    private static boolean isBalanced(String str, int index, int balance) {
        // Base case: If the index reaches the end of the string
        if (index == str.length()) {
            return balance == 0;
        }

        // Recursive case: Process each character
        char currentChar = str.charAt(index);

        if (currentChar == '(') {
            return isBalanced(str, index + 1, balance + 1);
        } else if (currentChar == ')') {
            // If there is no opening parenthesis to match the current closing parenthesis
            if (balance == 0) {
                return false;
            }
            return isBalanced(str, index + 1, balance - 1);
        } else {
            // Ignore any non-parenthesis characters
            return isBalanced(str, index + 1, balance);
        }
    }

    public static void main(String[] args) {
        String str1 = "((()))";
        System.out.println("Is \"" + str1 + "\" balanced? " + isBalanced(str1));

        String str2 = "()(())";
        System.out.println("Is \"" + str2 + "\" balanced? " + isBalanced(str2));

        String str3 = "())(";
        System.out.println("Is \"" + str3 + "\" balanced? " + isBalanced(str3));
    }
}
```

In this code, the recursive function `isBalanced` takes a string `str` as input and returns a boolean indicating whether the parentheses in the string are balanced.

The function uses an additional helper function `isBalanced` which takes the index, the balance count, and the string as parameters.

The base case is when the index reaches the end of the string. At this point, we check if the balance count is zero. If it is, then all parentheses have been matched, and the string is balanced. Otherwise, it is not balanced.

In the recursive case, we process each character in the string. If the character is an opening parenthesis '(', we increment the balance count and make a recursive call with the next index.

If the character is a closing parenthesis ')', we check if there is a matching opening parenthesis by comparing the balance count with zero. If the balance count is zero, then there is no opening parenthesis to match the current closing parenthesis, and the string is not balanced. Otherwise, we decrement the balance count and make a recursive call with the next index.

If the character is neither an opening nor a closing parenthesis, we simply ignore it and make a recursive call with the next index.

In the `main` method, we test the `isBalanced` function with a few example strings. We print whether each string is balanced or not.

When you run this code, it will output:
```
Is "((()))" balanced? true
Is "()(()" balanced? true
Is "())(" balanced? false
```

In this example, the first two strings have balanced parentheses, while the third string does not.
