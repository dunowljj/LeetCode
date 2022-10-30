class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        int[] checker = new int[26];
        
        if (s.length() < p.length()) return result;

        int diff = 0;
        
        // anagram 문자들 초기화
        for (int i = 0; i < p.length(); i++) {
            int idx = p.charAt(i) - 'a';
            
            if (checker[idx] == 0) diff++;
            checker[idx]++;     
        }
        
        // 첫 구간
        for (int i = 0; i < p.length(); i++) {
            int idx = s.charAt(i) - 'a';
            
            if (checker[idx] == 0) diff++;
            else if (checker[idx] == 1) diff--;
            checker[idx]--;
        }
        
        int start = 0;
        
        // 첫 문자열 검사
        if (diff == 0) result.add(start);
        
        for (int i = p.length(); i < s.length(); i++) {
            
            // start
            int idx = s.charAt(start) - 'a';
            
            if (checker[idx] == 0) diff++;
            else if (checker[idx] == -1) diff--;
            checker[idx]++; start++;
            
            
            // end
            idx = s.charAt(i) - 'a';

            if (checker[idx] == 0) diff++;
            else if (checker[idx] == 1) diff--;
            checker[idx]--;
            
            if (diff == 0) result.add(start);
        }
        
        return result;
    }
}
/*
탐색하며 알파벳 --
window에서 빠져나오는 알파벳 ++
모든 값 0이하이면 일치


*/