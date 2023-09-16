#
Longest Substring Without Repeating Characters: Given a string, find the length of the longest substring without repeating characters. For example, if the input is "abcabcbb", the output should be 3 (which corresponds to the substring "abc").
#
Here's an example implementation of finding the length of the longest substring without repeating characters in Java:

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();

        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                maxLen = Math.max(maxLen, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return maxLen;
    }
}
```

This solution uses a sliding window approach to find the length of the longest substring without repeating characters. The `i` and `j` pointers represent the start and end indices of the current substring being considered. The `set` data structure is used to keep track of the unique characters in the current substring.

The algorithm iterates through the string while expanding the window (`j` moves forward) as long as there are no repeating characters. When a repeating character is encountered, the window contracts (`i` moves forward) and the repeating character is removed from the set. The maximum length of the non-repeating substring is updated whenever a longer substring is found.

At the end of the iteration, the algorithm returns the length of the longest substring without repeating characters.

For example, given the input string "abcabcbb", the algorithm would produce the following steps:

```
i = 0, j = 0, maxLen = 0, set = {}
i = 0, j = 1, maxLen = 1, set = {a}
i = 0, j = 2, maxLen = 2, set = {a, b}
i = 0, j = 3, maxLen = 3, set = {a, b, c}
i = 1, j = 4, maxLen = 3, set = {b, c}
i = 2, j = 5, maxLen = 3, set = {c}
i = 3, j = 6, maxLen = 3, set = {a}
i = 4, j = 7, maxLen = 3, set = {a, b}
i = 5, j = 8, maxLen = 3, set = {a, b, c}
```

The final result would be 3, which corresponds to the substring "abc".
