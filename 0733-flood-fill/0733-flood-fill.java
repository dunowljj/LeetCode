import java.util.*;

class Solution {

    private final int[][] mapper = {{-1,1,0,0},{0,0,-1,1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int originColor = image[sr][sc];

        if (originColor == color) return image;
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(sr, sc));
        while (!queue.isEmpty()) {
            Point now = queue.poll();

            image[now.y][now.x] = color;
            
            for (int i = 0; i < 4; i++) {
                int ny = now.y + mapper[0][i];
                int nx = now.x + mapper[1][i];

                if (ny < 0 || ny >= image.length || nx < 0 || nx >= image[0].length 
                || image[ny][nx] != originColor) continue;

                queue.offer(new Point(ny, nx));
            }
        }

        return image;
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}