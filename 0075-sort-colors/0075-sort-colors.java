class Solution {
    public void sortColors(int[] nums) {
        
        // bubble sort
        int swapCount = 1;
        while (swapCount != 0) {
            swapCount = 0;

            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i] ;
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    swapCount++;
                }
            }
        }
    }
}

