class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> checker = new HashSet();
        
        for (int i = 0; i < nums.length; i++) {
            checker.add(nums[i]);
        }
        
        return nums.length != checker.size();
    }
}