import java.util.*;

class Solution {
    Set<Character> used = new HashSet<>();

    public int lengthOfLongestSubstring(String s) {

        int maxLen = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            while (right < s.length() && !used.contains(s.charAt(right))) {
                used.add(s.charAt(right));
                right++;

                maxLen = Math.max(maxLen, used.size());
            }

            if (right == s.length())
                break;

            while (used.contains(s.charAt(right))) {
                used.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }
}