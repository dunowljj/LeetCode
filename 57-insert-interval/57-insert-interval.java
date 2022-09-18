class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList();
        
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }
        
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        
        list.add(new int[]{newInterval[0], newInterval[1]});
        
        
        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }
        
        return list.toArray(new int[0][0]);
    }
}

/*
{1,3} // {4,7}  {8,11}
                {9,11}
                {10,11}
1,4,10 -- 9
{5,9}

중복되는 곳을 합치는 메커니즘은 더 작은범위가 시작, 더 큰 범위가 끝이 된다.

해당 범위에 속할때 가장 작은값. 해당 범위에 속할때 가장 큰 값.

*/