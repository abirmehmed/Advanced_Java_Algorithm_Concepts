#
String Reversal: Write a recursive function to reverse a given string. in java .
#

```java
public class StringReversal {
    public static String reverseString(String str) {
        if (str.isEmpty()) {
            return str;
        } else {
            return reverseString(str.substring(1)) + str.charAt(0);
        }
    }

    public static void main(String[] args) {
        String input = "Hello, World!";
        String reversed = reverseString(input);
        System.out.println("Original string: " + input);
        System.out.println("Reversed string: " + reversed);
    }
}
```

In this code, the recursive function `reverseString` takes a `str` as input and returns the reversed string.

The base case is when the input string is empty. In this case, the function simply returns the empty string.

In the recursive case, the function makes a recursive call to `reverseString` with the substring starting from the second character (`str.substring(1)`) and then concatenates the first character (`str.charAt(0)`) to the end of the reversed substring.

In the `main` method, we define an input string "Hello, World!" and call the `reverseString` function with this input. We then print the original string and the reversed string.

When you run this code, it will output the original string "Hello, World!" and the reversed string "!dlroW ,olleH".
