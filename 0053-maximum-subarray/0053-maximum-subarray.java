class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int left = 0;
        int right = nums.length - 1;

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;    
    
        for (int num : nums) {
            sum += num;
            
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) sum = 0;
        }

        return maxSum;
    }
}