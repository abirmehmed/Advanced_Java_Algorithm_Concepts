```
# Reverse a String: Write a function that takes a string as input and returns the reverse of the string.
For example, if the input is "hello", the output should be "olleh".
```


To reverse a string in Java, you can use the following approach:

```java
public class ReverseString {
    public static String reverse(String input) {
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        String reversedString = reverse(input);
        System.out.println(reversedString);
    }
}
```

In the `reverse` method, we create a `StringBuilder` object called `reversed` to store the reversed string. We iterate through the characters of the input string in reverse order using a `for` loop, and append each character to the `reversed` string using the `append` method. Finally, we convert the `StringBuilder` object to a string using the `toString` method and return it.

In the `main` method, we create a sample input string "hello" and call the `reverse` method to get the reversed string. We then print the reversed string to the console.

When you run the code, the output will be:

```
olleh
```

This is the reversed string of "hello".
