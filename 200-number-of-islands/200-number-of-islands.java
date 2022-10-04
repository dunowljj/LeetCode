class Solution {
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length; // point
        
        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    bfs(i, j, m, n, grid);
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private void bfs(int i, int j, int m, int n, char[][] grid) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{i,j});
        
        int mapper[][] = {{1,-1,0,0},{0,0,1,-1}};
        
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            
            for (int k = 0; k < 4; k++) {
                int nx = point[0] + mapper[0][k];
                int ny = point[1] + mapper[1][k];
                
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] == '0') continue;
                
                grid[nx][ny] = '0';
                queue.offer(new int[]{nx, ny});
            }
        }
    }
}