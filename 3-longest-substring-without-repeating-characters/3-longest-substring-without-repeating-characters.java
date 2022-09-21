class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        int maxLength = 0;
        
        int start = 0;
        int end = 0;
        while (s.length() - end > 0) {
            char curr = s.charAt(end);
            if (!set.contains(curr)) {
                set.add(curr);
                maxLength = Math.max(maxLength, set.size());
                end++;
                continue;
            }
            set.remove(s.charAt(start++));
        }
        
        return maxLength;
    }
}
/*
length 0~50_000

substring : 처음 주어진 Input에서 substring 한 결과의 길이를 내야한다. 연속하지 않은 숫자를 추출한 것은 안된다.

양끝 인덱스를 지정해서, 같은 숫자가 나오면 제거하고, 앞 인덱스를 이동?
cbbd가 처음에 있다면? set에 b만 남고, d로 넘어감.
ccb -> c제거 -> cb

수에 상관없이 앞에거를 set에서 제거하면서 새로운 수는 set에 넣기. -> substring을 구하는 문제이기때문에, 어짜피 연속된 문자들을 구해야 한다.
앞에서부터 제거하기떄문에 결국 set에는 연속된 문자들만 남는다. 수가 추가되면 최댓값을 비교해서 구해준다.

*/