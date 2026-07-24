class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;

        for (int num : nums) {
            if (num == 0) red++;
            if (num == 1) white++;
            if (num == 2) blue++;
        }

        Arrays.fill(nums, 0, red, 0);
        Arrays.fill(nums, red, red + white, 1);
        Arrays.fill(nums, red + white, nums.length, 2);
    }
}