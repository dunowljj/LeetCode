class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0) return 0;
        
        StringBuilder builder = new StringBuilder();
        char sign = '\u0000';
        int start = 0;
        
        // 맨 앞 공백 무시
        while (s.charAt(start) == ' ') {
            start++;

            if (s.length() == start) {
                return 0;
            }
        }
        
        
        // 첫 자리 부호인지 확인, 부호이면 시작점 변경
        char first = s.charAt(start);
        if (first == '-') {
            sign = '-';
            start++;
        }
        
        if (first == '+') {
            start++;
        }
        
        // 0~9 발견시 append / 아니면 종료 (' '도 종료)
        for (int i = start; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if ('0' <= curr && curr <= '9') {
                builder.append(curr);
            } else {
                break;
            }
        }
        
        // 맨 앞의 0 모두 제거
        while (builder.length() != 0 && builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }
        
        // 값 x : 문자 먼저 발견 혹은 숫자 없음
        if (builder.length() == 0) return 0;
        
        
        /**
         * clamp
         * 길이가 11보다 크면 부호에 따라 최댓값 혹은 최솟값 반환
         * 길이 11일때는 부호에 따라 최댓값, 최솟값과 사전순 비교. 
         */
        
        // 부호 체크, -인 경우만 append해서 후에 사전비교에 사용
        boolean isNegative = sign == '-';
        
        // 길이 10 초과 -> 범위 초과
        if (builder.length() > 10) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        
        // 사전 비교를 위해 부호 맨 앞에 더하기
        if (isNegative) builder.insert(0, sign);

        String result = builder.toString();
        String max = Integer.MAX_VALUE +"";
        String min = Integer.MIN_VALUE +"";
        
        // 사전 비교로 범위 초과시 clamp
        if (!isNegative && result.length() == 10) result = result.compareTo(max) >= 0 ? max : result;
        if (isNegative && result.length() == 11) result = result.compareTo(min) >= 0 ? min : result;
        
        return Integer.parseInt(result);
    }
}

/*
If no digits were read, then the integer is 0.
*/
