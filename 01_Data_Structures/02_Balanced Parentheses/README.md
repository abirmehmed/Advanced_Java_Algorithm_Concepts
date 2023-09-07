To check if a string of parentheses is balanced, you can use a stack data structure in Java. Here's an example implementation:

```java
import java.util.Stack;

public class BalancedParentheses {
    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input1 = "((()))";
        String input2 = "(()))";

        boolean isBalanced1 = isBalanced(input1);
        boolean isBalanced2 = isBalanced(input2);

        System.out.println("Input: " + input1 + ", Balanced: " + isBalanced1);
        System.out.println("Input: " + input2 + ", Balanced: " + isBalanced2);
    }
}
```

In the `isBalanced` method, we use a stack to store opening parentheses. We iterate through each character of the input string. If we encounter an opening parenthesis, we push it onto the stack. If we encounter a closing parenthesis, we check if the stack is empty. If it is, then the parentheses are not balanced, and we return `false`. If the stack is not empty, we pop the top character from the stack and check if it matches the closing parenthesis. If it doesn't match, we return `false`. Finally, after iterating through all the characters, if the stack is empty, it means all the opening parentheses have been matched, and the parentheses are balanced, so we return `true`. Otherwise, if the stack is not empty, it means there are unmatched opening parentheses, and the parentheses are not balanced, so we return `false`.

In the `main` method, we create two sample input strings: "((()))" and "(()))". We call the `isBalanced` method for each input string and print the results to the console.

When you run the code, the output will be:

```
Input: ((())), Balanced: true
Input: (())), Balanced: false
```

This confirms that the first input string is balanced, while the second input string is not.
