class Solution {
    int count = 0;
    
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            grid[i][0] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            grid[0][i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j -1];
            }
        }
        
        return grid[m -1][n -1];
    }
}


/*
The test cases are generated so that the answer will be less than or equal to 2 * 10^9.
The robot can only move either down or right

dfs, bfs 크게 상관없을듯 하다.

생각해보면 굳이 완전탐색을 할 이유가 없다. 시간도 엄청나게 걸린다.


[<((2 + 2) + 3) * 2 > + 4] * 2
*/