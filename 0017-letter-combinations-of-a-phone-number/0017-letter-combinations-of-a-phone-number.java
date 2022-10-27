class Solution {
    List<String> result = new ArrayList();
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return result;
        
        char[][] represent = {{' ',' '}
                            ,{' ',' '}
                            ,{'a','b','c'} //2
                            ,{'d','e','f'} //3
                            ,{'g','h','i'} //4
                            ,{'j','k','l'} //5
                            ,{'m','n','o'} //6
                            ,{'p','q','r','s'}
                            ,{'t','u','v'}
                            ,{'w','x','y','z'}}; //9
        
        char[] digitArr = digits.toCharArray();
        int[] nums = new int[digitArr.length];
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = digitArr[i] - '0';
        }
        
        combination(represent, nums, new char[digits.length()], 0);
        
        return result;
    }
    
    private void combination(char[][] represent, int[] nums, char[] comb, int depth) {
        if (depth == nums.length) {
            String answer = "";
            for (char ch : comb) {
                answer += ch;
            }
            result.add(answer);
            return;
        }
        
        int num = nums[depth];

        //0~4번째를 각각 순회하게 만들어야한다.
        for (int i = 0; i < represent[num].length; i++) {
            comb[depth] = represent[num][i];
            combination(represent, nums, comb, depth + 1);
        }
    }
}
/*
0 <= digits.length <= 4
(3~4)^4
*/