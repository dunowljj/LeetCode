class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();
        if (s.length() < p.length()) return answer;

        int[] counts = new int[26];
        int need = 0;
        for (int i = 0; i < p.length(); i++) {
            int idx = p.charAt(i) - 'a';
            need++;
            counts[idx]++;
        }
        
        for (int i = 0; i < p.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (counts[idx] >= 1) need--;
            counts[idx]--;
        }

        if (need == 0) {
            answer.add(0);
        }   

        int l = 0;
        int r = p.length();

        while (r < s.length()) {
            int remove = s.charAt(l) - 'a';
            int add = s.charAt(r) - 'a';
            
            // if remove==add need to seperate inc
            if (counts[remove] >= 0) need++;
            counts[remove]++;
            
            if (counts[add] >= 1) need--;            
            counts[add]--;
            
            l++; r++;

            if (need == 0) {
                answer.add(l);
            }
        }

        return answer;
    }
}