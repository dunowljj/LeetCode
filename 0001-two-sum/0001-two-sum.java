import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        Map<Integer, Integer> numMap = new HashMap<>(); 
        // <num,index>

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            
            if (numMap.containsKey(diff)) {
                answer[0] = numMap.get(diff);
                answer[1] = i;

                return answer;
            }

            numMap.put(nums[i], i);
        }

        return answer;
    }
}
/**
 * 1) sort and binary search
 * 2) hash
 */