class Solution {
    public int[][] merge(int[][] intervals) {
        
        
        Arrays.sort(intervals, (o1,o2) -> o1[0] - o2[0]);
        
        // 1,4 - 2,3
        List<int[]> list = new ArrayList();
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length - 1; i++) {
            
            if (end >= intervals[i + 1][0]) {
                end = Math.max(end, intervals[i + 1][1]);
            } 
            
            else {
                list.add(new int[]{start,end});
                start = intervals[i + 1][0];
                end = intervals[i + 1][1];
            }
        }

        int len = intervals.length - 1;
        end = Math.max(end, intervals[len][1]);
        
        list.add(new int[]{start, end});
        
        
        return list.toArray(new int[0][]);
    }
}