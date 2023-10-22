
```java
public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        // base case: if the string is empty or has only one character, it is a palindrome
        if (str.length() <= 1) {
            return true;
        }
        
        // check if the first and last characters are equal
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            // recursively check if the substring without the first and last characters is a palindrome
            return isPalindrome(str.substring(1, str.length() - 1));
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "racecar";
        boolean isPal = isPalindrome(str);
        if (isPal) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }
    }
}
```

In this code, the `isPalindrome` function takes a string `str` as input and checks if it is a palindrome using recursion.

The function first checks if the length of the string is less than or equal to 1 (base case), in which case it is considered a palindrome and returns `true`. Otherwise, it compares the first and last characters of the string. If they are equal, it recursively calls itself with the substring that excludes the first and last characters. This process continues until the base case is reached or if any pair of characters are found to be unequal, in which case it returns `false`.

The `main` function demonstrates the usage of the `isPalindrome` function by checking if the string "racecar" is a palindrome, and prints the result accordingly.
