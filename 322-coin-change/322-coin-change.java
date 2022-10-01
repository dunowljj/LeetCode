class Solution {
    Integer[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[10_001];
        
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    int before = dp[i - coins[j]];
                    
                    if (before != Integer.MAX_VALUE && dp[i] > before + 1) {
                        dp[i] = before + 1;
                    }
                }
            }
        }
        
        int result = dp[amount];
        return result == Integer.MAX_VALUE ? -1 : result;
        
    }
    

       
    
}
/*
1 <= coins[i] <= 2^31 - 1
0 <= amount <= 10^4

1,5,6 -> 10 : 2

// 31 -> 7,11,13 나누기만 사용시 불가능

*/