class Point implements Comparable<Point>{
    int x;
    int y;
    int powSum;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.powSum = (int)Math.pow(x,2) + (int)Math.pow(y,2);
    }
    
    @Override
    public int compareTo(Point p) {
        return this.powSum -  p.powSum;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue();
        

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            
            pq.offer(new Point(x,y)); 
        }
        
        List<int[]> list = new ArrayList();
        
        while (k-- > 0){
            // && !pq.isEmpty()) {
            Point point = pq.poll();
            
            list.add(new int[]{point.x, point.y});
        }
        
        return list.toArray(new int[0][0]);
    }
}
