import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int soulmate = target - nums[i];
            
            if (map.containsKey(soulmate)) {
                int index = map.getOrDefault(soulmate, -1);
                
                if (i != index) {
                    return new int[]{i, index};
                }
            }
        }
        
        return new int[]{};
    }
}
/*
if brute force : O(N^2)

2 <= len <= 1000 -> 100milion

- Only one valid answer
- return order free

*/