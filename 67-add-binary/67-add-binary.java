class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        
        int len = Math.max(a.length(), b.length()) + 1;
        int[] answer = new int[len + 1];
        
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
       
        len = answer.length - 1;        
        int lenA = a.length() - 1;
        while (lenA >= 0) {
            answer[len--] += arrA[lenA--] - '0';
        }
        
        len = answer.length - 1;             
        int lenB = b.length() - 1;
        while (lenB >= 0) {
            answer[len--] += arrB[lenB--] - '0';
        }
        
        
            
        len = answer.length;
        while (len-- > 0) { //len - 1 ~ 0
            int value = answer[len];
            
            // 3 or 2
            if (len != 0) answer[len - 1] += value / 2; 
            
            result.append((value % 2)+"");
        }
        
        result.reverse();
        while (result.charAt(0) == '0' && result.length() != 1) {
            result.delete(0, 1);
        }

        
       return result.toString();
    }
}
/*
length <= 10_000
does not contain leading zeros
*/