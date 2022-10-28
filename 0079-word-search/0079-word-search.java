class Solution {
    int[][] mapper = {{-1,1,0,0},{0,0,1,-1}};
    boolean[][] visited;
    boolean isWord = false;
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        
        char first = word.charAt(0);
        
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == first) {
                    visited[i][j] = true;
                    dfs(board, m, n, word, 1, i, j);
                    visited[i][j] = false;
                }
            }
        }
        
        return isWord;
    }
    
    private void dfs(char[][] board, int m, int n, String word, int depth, int row, int col) {
        if (depth == word.length()) {
            isWord = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = row + mapper[0][i];
            int nc = col + mapper[1][i];
        
            if (nr < 0 || nc < 0 || nr >= m || nc >= n
                || board[nr][nc] != word.charAt(depth) || visited[nr][nc]) continue;

            visited[nr][nc] = true;
            dfs(board, m, n, word, depth + 1, nr, nc);
            visited[nr][nc] = false;
        }
    }
}

/*
 The same letter cell may not be used more than once.
*/