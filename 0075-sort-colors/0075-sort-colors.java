class Solution {
    public void sortColors(int[] nums) {
        int[] lens = new int[3];
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) lens[0]++;
            if (nums[i] == 1) lens[1]++;
            if (nums[i] == 2) lens[2]++;
        }
        
        lens[1] += lens[0];
        lens[2] += lens[1];
        
        for (int i = 0; i < lens[2]; i++) {
            if (i < lens[0]) {
                nums[i] = 0;
            } else if (i < lens[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}