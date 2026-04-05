import java.util.*;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        Job[] jobs = new Job[n];
        int[] dp = new int[n + 1]; // lowerbound시에 모두 F이면 dp[nidx] 0반환

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(j -> j.startTime));

        for (int i = n - 1; i >= 0; i--) {
            int nIdx = lowerBound(i, jobs);
            int take = jobs[i].profit + dp[nIdx];
            int skip = dp[i + 1];

            dp[i] = Math.max(take, skip);
        }

        return dp[0];
    }

    public int lowerBound(int i, Job[] jobs) {
        int targetEnd = jobs[i].endTime;
        int lo = i + 1;
        int hi = jobs.length;

        // F F T T T T
        // T T T T T T
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            // T
            if (targetEnd <= jobs[mid].startTime) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    static class Job {
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}

/**
 * 가장 큰 증가하는 부분수열과 비슷?
 * 
 * dp[i]는 i번째 profit부터 마지막 profit까지 고려했을때 가장 합이 큰 경우
 */