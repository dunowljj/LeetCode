class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int zeroCount = 0;
        int zeroIndex = 0;
        int total = 1;
        
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) { 
                zeroCount++;
                zeroIndex = i;
                
                if (zeroCount > 1) return answer;
            }
            
            else {
                total *= nums[i];
            }
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