class Solution {
    
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            
            int left = i;
            int right = i;

            while (right < s.length() - 1 && s.charAt(right) == s.charAt(right + 1)) {
                right++;
            }

            while (left > 0 && right < s.length() - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
                right++;
                left--;
            }
        
            int nowLen = right - left + 1;
            
            if (maxLen < nowLen) {
                maxLen = nowLen;
                start = left;
            }
        }
        
        return s.substring(start, start + maxLen);
    }
       
}


/*
대칭인 경우
최대 1000개의 문자의 substring을 모두 뒤집어보기?
반복되는 경우

palindromic substring의 특징 : 대칭되는 위치의 값이 같아야 한다. -> n == (length - 1 - n);

1) 각 인덱스마다 탐색
- 해당 인덱스부터 양쪽으로 검사한다.
- 같은 값이 연속적으로 나타난 경우를 고려한다.
- 길이가 짝수인 palindromic substring은 가운데 두 문자가 같다. 연속적인 경우를 해결하면 자동으로 해결된다.

길이를 캐싱할수는 없을까?
ex. abcbcba
1) [0]탐색 : p-> abcbbba
2) [1]탐색 : 어짜피 [1]은 최대 길이가 3 or 4
길이를 저장?
*/