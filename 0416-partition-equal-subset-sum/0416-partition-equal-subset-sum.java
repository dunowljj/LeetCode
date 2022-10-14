class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 1) return false;
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        if (sum % 2 != 0) return false;
        
        int half = sum / 2;
        
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        
        for (int x = 0; x < nums.length; x++) {
            for (int i = half; i >= nums[x]; i--) {
                dp[i] = dp[i] || dp[i - nums[x]];
            }
        }
        
        return dp[half];
    }
}
/*
1 <= nums.length <= 200
1 <= nums[i] <= 100

22/ 2 == 11

dp[1] = ture;
dp[5] = true;
dp[6] = true;
dp[12] = true;
dp[16] = true;
dp[17] = true;

dp[11] = true;


*/