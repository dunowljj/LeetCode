class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) /2;

            
            if (target == nums[mid]) {
                return mid;
            }
            
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            
            if (nums[mid] <= nums[end]) {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
/*
0 1 2 3 4
1, 2
binarySearch
1 <= nums.length <= 5000
You must write an algorithm with O(log n) runtime complexity.

ascend, pivot -> 중간에서 어느 방향을 탐색해야하는가?

4,5,6,7,0,1,2
앞부분이 더 작음 -> 정상 / 앞부분이 더 큼 -> pivot 존재
뒷부분이 더 작음 -> pivot 존재 / 뒷부분이 더 큼 -> 정상

앞이 크고 뒤가 작은경우는 없다.






3, 4, 0, 1, 2



1) start <= mid



mid >= end
mid < end
start > mid -> 


*/