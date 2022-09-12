class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        
        for (int i = 0; i < nums.length; i++) {
            int value = map.getOrDefault(nums[i],0);
            map.put(nums[i], value + 1);
            
            if (value >= nums.length / 2) {
                return nums[i];
            }
        }
        
        return -1;
    }
}