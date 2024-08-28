import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> countMap = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        for (Character tch : t.toCharArray()) {
            if (!countMap.containsKey(tch)) {
                return false;
            } 
            
            else {
                int count = countMap.get(tch);
                
                if (count == 0) return false;
                else countMap.put(tch, count - 1);
            }
        }

        return true;
    }
}