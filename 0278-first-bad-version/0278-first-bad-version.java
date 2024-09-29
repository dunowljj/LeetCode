public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        
        // F F F T T T T -> find first T
        while (lo + 1 <= hi) {

            int mid = (hi - lo) / 2 + lo;

            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}