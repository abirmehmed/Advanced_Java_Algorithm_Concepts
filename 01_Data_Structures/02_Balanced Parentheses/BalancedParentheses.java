//Write a function that takes a string of parentheses as input and determines whether the parentheses are balanced. For example, if the input is "((()))", the output should be true, but if the input is "(()))", the output should be false.

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
