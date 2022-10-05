class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<Point> rottenQueue = new LinkedList();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) rottenQueue.offer(new Point(i,j));
            }
        }
        
        int minute = 0;
        if (fresh == 0) return minute;
        
        int[][] mapper = {{-1,1,0,0}, {0,0,-1,1}};
        boolean reachable;
        
        while (!rottenQueue.isEmpty()) {
            int len = rottenQueue.size();
            reachable = false;
            minute++;
            
            for (int i = 0; i < len; i++) {
                Point point = rottenQueue.poll();
            
                for (int j = 0; j < 4; j++) {
                    int nx = point.x + mapper[0][j];
                    int ny = point.y + mapper[1][j];

                    if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length
                       || grid[nx][ny] != 1) continue;

                    // 1 -> 2
                    grid[nx][ny] = 2; 
                    rottenQueue.offer(new Point(nx,ny));
                    fresh--;
                    reachable = true;
                }
            }
            
            if (fresh == 0) return minute;
            if (!reachable) break;
        }
        
        return -1;
    }
}

/*
count fresh

rotten start -> find -> fresh--;

per depth -> if (beforeFresh == fresh) 
*/