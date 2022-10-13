class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] available = new boolean[s.length() + 1];
        
        available[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (available[j] && wordDict.contains(s.substring(j,i))) {
                    available[i] = true;
                }
            }    
        }
        
        return available[s.length()];
    }
}
/*
s.length : 1 ~ 300
사전 단어 수 1~1000
단어 길이 1~20

1)
discuss에 dp 활용
*/