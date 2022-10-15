class Solution {
    List<List<Integer>> answer = new ArrayList();
    
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums , 0, new ArrayList());   
        
        return answer;
    }
    
    private void dfs(int[] nums, int idx, List<Integer> list) {
        answer.add(list);
        
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            dfs (nums, i + 1, new ArrayList(list));
            list.remove(list.size() - 1);
        } 
    }
}