import java.util.*;

class Solution {

    int m,n;
    int[][] newMat;
    final int[][] mapper = {{0,0,-1,1},{-1,1,0,0}};

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        newMat = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(newMat[i], Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 0) {
                    newMat[r][c] = 0;
                    queue.offer(new int[]{r,c});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int ny = now[0] + mapper[0][dir];
                int nx = now[1] + mapper[1][dir];

                if (ny < 0 || ny >= m || nx < 0 || nx >= n) continue;
                if (newMat[ny][nx] < newMat[now[0]][now[1]] + 1) continue;
                
                newMat[ny][nx] = newMat[now[0]][now[1]] + 1;
                queue.offer(new int[]{ny,nx});
            }
        }

        return newMat;
    }
}