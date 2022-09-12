class Solution {
    public int majorityElement(int[] nums) {
        
        if (nums.length == 1) {
            return 1;
        }
        
        Arrays.sort(nums);
        
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
                
                if (count >= nums.length / 2) {
                    return nums[i];
                }
                
            } else {
                count = 0;
            }
        }
        return -1;
    }
}

//         Map<Integer,Integer> map = new HashMap();
        
//         for (int i = 0; i < nums.length; i++) {
//             int value = map.getOrDefault(nums[i],0);
//             map.put(nums[i], value + 1);
            
//             if (value >= nums.length / 2) {
//                 return nums[i];
//             }
//         }
        

    