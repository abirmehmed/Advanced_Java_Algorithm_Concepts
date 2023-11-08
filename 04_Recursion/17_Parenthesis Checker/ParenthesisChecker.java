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
