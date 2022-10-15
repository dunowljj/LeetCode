class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList();
        int m = matrix.length;
        int n = matrix[0].length;
        int size = getSize(m,n);
        boolean[][] visited = new boolean[m][n];
        
        int[][] mapper = {{0, 1, 0, -1},{1, 0, -1, 0}};        
        
        answer.add(matrix[0][0]);
        visited[0][0] = true;
        int x = 0, y = 0, nx = 0, ny = 0, dir = 0;
        while (size-- > 1) {
            nx = x + mapper[0][dir % 4];
            ny = y + mapper[1][dir % 4];
            
            if (nx < 0 || ny < 0 || nx >= m || ny >= n
               || visited[nx][ny]) {
                dir++;
                size++;
                continue;
            }

            visited[nx][ny] = true;
            answer.add(matrix[nx][ny]);
            x = nx;
            y = ny;
        }
        
        return answer;
    }
    
    private int getSize(int m, int n) {
        if (m == 0) return n;
        if (n == 0) return m;
        
        return m*n;
    }
}