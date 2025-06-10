import java.util.*;

class Solution {

    List<List<Integer>> permutations = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        permute(0, nums.length, new ArrayList<>(), nums);
        return permutations;
    }

    public void permute(int depth, int n, List<Integer> permutation, int[] nums) {
        if (depth == n) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < n; i++) {
           if (visited[i]) continue;
           
           permutation.add(nums[i]);
           visited[i] = true;
           
           permute(depth + 1, n, permutation, nums);
           
           permutation.remove(permutation.size() - 1);
           visited[i] = false;
        }
    }
}