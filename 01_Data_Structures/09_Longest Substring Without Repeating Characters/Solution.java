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
