class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        int[] checker = new int[26];
        
        if (s.length() < p.length()) return result;
        
        // anagram 문자들 초기화
        for (int i = 0; i < p.length(); i++) {
            checker[p.charAt(i) - 'a']++;     
        }
        
        // 첫 구간
        for (int i = 0; i < p.length(); i++) {
            char curr = s.charAt(i);
            checker[curr - 'a']--;
        }
        
        int start = 0;
        
        // 첫 문자열 검사
        if (isAnagram(checker)) result.add(start);
        
        for (int i = p.length(); i < s.length(); i++) {
            checker[s.charAt(start++) - 'a']++;
            checker[s.charAt(i) - 'a']--;
                
            if (isAnagram(checker)) result.add(start);
        }
        
        return result;
    }
    
    private boolean isAnagram(int[] checker) {
        for (int count : checker) {
            if (count != 0) return false;
        }
        return true;
    }
    
    // private void test(int[] checker) {
    //     for (int count : checker) {
    //         System.out.print(count+" ");
    //     }
    //     System.out.println();
    // }
}
/*
탐색하며 알파벳 --
window에서 빠져나오는 알파벳 ++
모든 값 0이하이면 일치


*/