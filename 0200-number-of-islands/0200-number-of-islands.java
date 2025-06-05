class Solution {

    int n,m,count;
    final int[][] mapper = {{0,0,1,-1},{-1,1,0,0}};

    public int numIslands(char[][] grid) {
        count = 0;
        n = grid.length;
        m = grid[0].length;
        for (int i = 0; i < n; i++){ 
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    
                    bfs(i, j, grid);

                    grid[i][j] = '0';
                    count++;
                }
            }
        }

        return count;
    }

    public void bfs(int y, int x, char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});

        while (!q.isEmpty()) {
            
            int nowY = q.peek()[0];
            int nowX = q.poll()[1];

            for (int dir = 0; dir < 4; dir++) {
                int ny = nowY + mapper[0][dir];
                int nx = nowX + mapper[1][dir];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (grid[ny][nx] == '0') continue;

                grid[ny][nx] = '0';
                q.offer(new int[]{ny,nx});
            }
        }
    }
}