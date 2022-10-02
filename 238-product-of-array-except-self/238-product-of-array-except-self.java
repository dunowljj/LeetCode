class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int zeroCount = 0;
        int zeroIndex = 0;
        
        int total = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) { 
                zeroCount++;
                zeroIndex = i;
            }
            
            else {
                total *= nums[i];
            }
        }
        
        
        int[] answer = new int[nums.length];
        
        if (zeroCount > 1) {
            return answer;
        }

        
        if (zeroCount == 1) {
            answer[zeroIndex] = total;
            return answer;
        }
        
        
        for (int i = 0; i < nums.length; i++) {
            answer[i] = total / nums[i];
        }
        
        return answer;
    }
}