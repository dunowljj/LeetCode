import java.util.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomMap = new HashMap<>();

        for (Character ch : ransomNote.toCharArray()) {
            int count = ransomMap.getOrDefault(ch, 0);            
            ransomMap.put(ch, count + 1);
        }

        for (Character ch : magazine.toCharArray()) {
            if (!ransomMap.containsKey(ch)) continue;
            
            int count = ransomMap.get(ch);
            
            if (count == 1) ransomMap.remove(ch);
            else ransomMap.put(ch, count - 1);
        }

System.out.println(ransomMap.size());
        return ransomMap.size() == 0;
    }
}