class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap();
        
        if (s.length() != t.length()) return false;
        
        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);
            
            map.put(chS, map.getOrDefault(chS, 0) + 1);
            map.put(chT, map.getOrDefault(chT, 0) - 1);
            
            if (map.get(chS) == 0) {
                map.remove(chS);
            }
            
            if (map.containsKey(chT) && map.get(chT) == 0) {
                map.remove(chT);
            }
        }
        
        return map.isEmpty();
    }
}