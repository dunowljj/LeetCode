class Point {
    int x;
    int y;
    int count;
    
    Point(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

class Solution {
    boolean[][] visited;
    
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] distances = new int[m][n];
        Queue<Point> queue = new LinkedList();
        visited = new boolean[m][n];
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    queue.offer(new Point(i,j,0));
                }
            }
        }
        
        bfs(queue, distances, mat, m, n);
        return distances;
    }
    
    private void bfs(Queue<Point> queue,int[][] distances,int[][] mat, int m, int n) {
        
        int[][] mapper = {{1,-1,0,0},{0,0,-1,1}};
        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + mapper[0][i];
                int ny = curr.y + mapper[1][i];
                int count = curr.count + 1;
                
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny]) continue;
                
                distances[nx][ny] = count;
                visited[nx][ny] = true;
                queue.offer(new Point(nx,ny, count));
            }
        }
    }
}

/*
최대 10_000개의 블럭

행이 1인 10_000개의 블럭을 탐색시 시간초과

- 처음에 1을 모두 찾고, 해당 위치마다 0을 찾아가는 방식을 사용했다.

시간초과가 나왔다. 1행짜리 다음과 같은 예시를 보자 (괄호 생략)
[1, 1, 1, 1, 1, 1, 1, 1, 0]
1) 맨 왼쪽 1부터 탐색하게 되고, 8칸 (*4회) 탐색을 해야 0에 도달하여 값을 구할 수 있다.
2) 그다음 요소는 각각 7칸, 6칸, 5칸을 모두 탐색해야한다.
3) 최악의 경우 10_000!번의 연산을 해야한다.

해결 : 0부터 시작, bfs로 탐색
1) 모든 0들을 방문체크하고, 0들을 모두 큐에 넣는다.
2) 0부터 시작하여 방문하지 않은 곳을 큐에 다시 넣고 count로 채워나간다.
-> 1을 한번씩만 방문하게 되며, bfs이기때문에 각 0에서 시작하여 같은 속도로 탐색하게 되고, 최단 0을 찾게 된다.

*/