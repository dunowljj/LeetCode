class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int l = 0;
        int r = n - 1;
        int max = 0;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            max = Math.max(max, h * (r - l));
            
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }
}
/**
수직선 개수 최대 10^5개 -> N
높이 최대 10^4

N^2 -> 시간 초과
투포인터로 그리디하게 탐색 
 */