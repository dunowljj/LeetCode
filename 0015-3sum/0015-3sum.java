import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        if (nums[0] > 0 || nums[len - 1] < 0) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Set<Integer>> idxMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            counts.put(num, counts.getOrDefault(num, 0) + 1);
            
            Set<Integer> idxs = idxMap.getOrDefault(num, new HashSet<>());
            idxs.add(i);
            idxMap.put(num, idxs);
        }

        Set<List<Integer>> answer = new HashSet<>();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (i == j) continue;

                int sum = nums[i] + nums[j];
                int pair = 0 - sum;
                
                if (counts.containsKey(pair)) {
                    Set<Integer> pairIdxs = idxMap.get(pair);
                    if (pairIdxs.size() == 2 && pairIdxs.contains(i) && pairIdxs.contains(j)) continue;
                    if (pairIdxs.size() == 1 && (pairIdxs.contains(i) || pairIdxs.contains(j))) continue;
                   
                    List<Integer> list = new ArrayList<>(List.of(nums[i], nums[j], pair));
                    Collections.sort(list);
                    answer.add(list);
                }
            }
        }

        return answer.stream().toList();
    }
}
/**

 */