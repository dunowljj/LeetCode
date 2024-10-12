import java.util.*;

class Solution {
    public int longestPalindrome(String s) {   
        Set<Character> set = new HashSet<>();

        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) set.remove(ch);
            else set.add(ch);
        }

        if (set.size() > 1) return s.length() - (set.size() - 1);
        else return s.length();
    }

}

/*
- case sensitive "Aa"
- s.length -> 1~2000

*/
