class Solution {
    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length - 1;
        
        int center;
        // 부등호에 주의, 모든 인덱스를 탐색한 다음 게속 탐색하면 시작점이 더 커진다. length 1을 고려해서 같은 경우도 포함해야한다.
        while (start <= end) {
            center = (start + end) / 2;

            int curr = nums[center];
            
            if (curr == target) return center;
            
            if (curr < target) {
                start = center + 1;
            } else {
                end = center - 1;
            }
            
        }
        
        return -1;
    }
}
/*
BinarySearch
1) Find middle

    start, ...middle - 1,  middle, middle + 1, ... end

2) Search
2-1) middle bigger than target -> start~(middle-1)
2-1) middle smaller than target -> (middle+1)~end

3) Current is equals to target -> return middle

*/
