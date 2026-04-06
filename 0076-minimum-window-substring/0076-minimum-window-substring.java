class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n == 0 || m == 0 || n < m) return "";
        
        int[] need = new int[128];
        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);

            need[ch]++;
        }

        int[] range = new int[2];
        int missing = t.length();
        int minLen = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;
        for (right = 0; right < n; right++) {
            char rc = s.charAt(right);

            if (need[rc] > 0) {
                missing--;
            }
            need[rc]--;

            while (missing == 0) {
                if (minLen > right - left) {
                    range = new int[]{left, right + 1};
                    minLen = right - left;
                }

                char lc = s.charAt(left);
                need[lc]++;

                if (need[lc] > 0) {
                    missing++;
                }
                left++;
            }
        }

        return s.substring(range[0], range[1]);
    }
}
/**
count, slide
 */