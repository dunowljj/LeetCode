class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, nums.length, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> set, int[] nums, int len, int idx) {
        result.add(new ArrayList<>(set));
        if (idx == len) return;

        for (int i = idx; i < len; i++) {
            set.add(nums[i]);
            dfs(result, set, nums, len, i + 1);
            set.remove(set.size() - 1);
        }
    }
}