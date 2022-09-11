class Solution {
    int[] memo = null;
    public int climbStairs(int n) {    
        
        memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        
        return dp(n);
        
    }
    
    private int dp(int n) {
        if (memo[n] != 0) {
            return memo[n];
        } 
        
        return memo[n] = dp(n - 2) + dp(n - 1);
    }
}

/*
순서가 다르면 중복이 아니다.

n = 1
1
---
n = 2
1 + 1
2 
---
n = 3
1 + 1 + 1
1 + 2
2 + 1

f(n) = f(n - 1) + f(n - 2)

*/
