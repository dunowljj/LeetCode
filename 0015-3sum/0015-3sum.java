import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();

        if (nums[0] > 0 || nums[n - 1] < 0) {
            return answer;
        }

        for (int fix = 0; fix < n; fix++) {
            if (fix > 0 && nums[fix] == nums[fix - 1]) continue;
            
            int left = fix + 1;
            int right = n - 1;    
            
            int fixVal = nums[fix];
            while (left < right) {
                int sum = fixVal + nums[left] + nums[right];

                if (sum == 0) {
                    answer.add(List.of(fixVal, nums[left], nums[right]));

                    left++;
                    right--;

                    while (left < right && nums[left - 1] == nums[left]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return answer;
    }   
}