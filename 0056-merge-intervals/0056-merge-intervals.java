import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        List<int[]> mergedIntervals = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            // duplicated
            if (curr[0] <= end) {
                end = Math.max(end, curr[1]);
            } else {
                mergedIntervals.add(new int[]{start, end});
                start = curr[0];
                end = curr[1];
            }
        }

        mergedIntervals.add(new int[]{start,end});

        return mergedIntervals.toArray(new int[0][]);
    }
}