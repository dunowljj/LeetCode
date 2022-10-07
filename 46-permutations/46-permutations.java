class Solution {
    List<List<Integer>> answer = new ArrayList();
    Set<Integer> set = new HashSet();
    
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        permutation(nums, new ArrayList());
        
        return answer;
    }
    
    private void permutation(int[] nums, List<Integer> temp) {
        if (set.size() == nums.length) {
            answer.add(new ArrayList(temp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!set.contains(num)) {
                set.add(num);
                temp.add(num);
                permutation(nums, temp);
                set.remove(num);
                temp.remove(temp.size() - 1);
            }
        }
    }
}