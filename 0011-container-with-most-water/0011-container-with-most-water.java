class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            
            if (height[left] < height[right]) {
                int preLeft = height[left];
                while (preLeft > height[++left]) {}
            }
            else if (height[left] > height[right]) {
                int preRight = height[right];
                while (preRight > height[--right]) {}
            } 
            else {
                int preLeft = height[left];
                int preRight = height[right];
                
                while (preLeft > height[++left]) {}
                while (preRight > height[--right]) {}
            }
        }
        return max;
    }
}
/*
2 <= n <= 10^5
0 <= height[i] <= 10^4

water = Max(h[i], h[j]) * (i - j)
O(n^2) ??
한 container 기준으로 바깥부터 다른 하나를 탐색하고, 더 긴그래프가 있을때만 검사하는건 어떨까?

1 1 1 1 1 1 1 1 1 6 6 1 1 1 1 1 1 1 2
3 2 2 2 1
1 10 3 4 5 10 5

discuss : 더 작은 포인터를 이동시키기. 같으면 둘 다 이동
*/