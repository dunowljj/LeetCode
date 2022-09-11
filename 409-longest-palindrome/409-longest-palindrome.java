class Solution {
    public int longestPalindrome(String s) {
        int answer = 0;
        // int[] counting = new int[52];
        int[] counting = new int[123];

        for (int i = 0; i < s.length(); i++) {
            counting[s.charAt(i)]++;
            
//             if ('a' <= curr && curr <= 'z') {
//                 counting[curr - 'a']++;
//                 continue;
//             }
            
//             if ('A' <= curr && curr <= 'Z') {
//                 counting[curr - 'A' + 26]++;
//                 continue;
//             }
        }
        
        boolean center = false;
        // for (int i = 0; i < 52; i++) {
        for (int i = 0; i < 123; i++) {

            int count = counting[i];
            
            answer += (count / 2) * 2;
            
            if (count % 2 == 1) {
                center = true;
            }
        }
        
        if (center) {
            answer++;
        }
        
        return answer;
    }
}

/*
1 <= s.length <= 2000
case sensitive
s consists of lowercase and/or uppercase English letters only.

method 1 
counting array -> each time have to check is upper/lower

method 2
use hashSet or map
*/