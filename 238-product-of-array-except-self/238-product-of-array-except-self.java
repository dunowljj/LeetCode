class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] fromLeft = nums.clone();
            
        for (int i = 0; i < nums.length - 1; i++) {
            fromLeft[i + 1] = fromLeft[i + 1] * fromLeft[i];
        }
        

        int[] fromRight = nums.clone();

        for (int i = fromRight.length - 1; i >= 1; i--) {
            fromRight[i - 1] = fromRight[i - 1] * fromRight[i];
        }
        
        int[] answer = new int[nums.length];
        answer[0] = fromRight[1];
        answer[nums.length - 1] = fromLeft[nums.length -2];
        
        for (int i = 1; i < nums.length - 1; i++) {
            answer[i] = fromLeft[i - 1] * fromRight[i + 1];
        }
        
        return answer;
    }
    
}
// 1 2 3 4

// fromLeft 1 2 6 24
// fromRight 24 24 12 4

// 24 12 