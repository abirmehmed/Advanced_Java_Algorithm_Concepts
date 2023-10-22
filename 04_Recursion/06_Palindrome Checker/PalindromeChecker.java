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
