class Solution {
    public void sortColors(int[] nums) {
        
        int front = 0;
        int back = nums.length - 1;
        
        for (int curr = 0; curr <= back; curr++) {
            if (nums[curr] == 0) {
                swap(nums, front, curr);
                front++;
            }
            
            else if (nums[curr] == 2) {
                swap(nums, back, curr);
                back--;
                curr--;
            }
        }
    }
    
    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}

/*
1 1 0 2 1 ; left 0 / right 4 / curr 0
1 1 0 2 1 ; left 0 / right 4 / curr 1
0 1 1 2 1 ; left 1 / right 4 / curr 2
0 1 1 1 2 ; left 1 / right 3 / curr 3


*/