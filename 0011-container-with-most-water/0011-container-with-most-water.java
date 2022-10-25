class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int ex_Iheight = 0;
        for (int i = 0; i < height.length; i++) {
            if (ex_Iheight >= height[i]) continue;
            ex_Iheight = height[i];

            int ex_Jheight = 0;
            for (int j = height.length - 1; j > i; j--) {
                if (height[j] > ex_Jheight) {
                    max = Math.max(max, calculate(height, i, j));
                    ex_Jheight = height[j];
                }
            }
        }
        return max;
    }
    
    private int calculate(int[] height, int idx1, int idx2) {
        return Math.min(height[idx1], height[idx2]) * (idx2 - idx1);
    }
}
/*
2 <= n <= 10^5
0 <= height[i] <= 10^4

water = Max(h[i], h[j]) * (i - j)
O(n^2) ??
한 container 기준으로 바깥부터 다른 하나를 탐색하고, 더 긴그래프가 있을때만 검사하는건 어떨까?

1 2 3 4 5 6 7 8 9 10
*/