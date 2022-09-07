class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        
        int startColor = image[sr][sc];
        
        if (startColor == color) {
            return image;
        }
        image[sr][sc] = color;
        
        
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{sr,sc});
        
        int[][] mapper = {{-1, 1, 0, 0},{0, 0, 1, -1}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + mapper[0][i];
                int ny = curr[1] + mapper[1][i];
                
                if (nx < 0 || ny < 0 || nx >= image.length || ny >= image[0].length) continue;
                
                if (image[nx][ny] == startColor) {
                    image[nx][ny] = color;
                    queue.offer(new int[]{nx,ny});
                } 
            }
        }
        
        return image;
    }
}