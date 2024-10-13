import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(
                i -> i,
                Collectors.counting()
            ));

        int max = Integer.MIN_VALUE;
        for (int count : map.values()) {
            max = Math.max(count, max);
        }

        return max;
    }
}