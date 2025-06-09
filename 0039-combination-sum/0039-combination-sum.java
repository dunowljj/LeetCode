class Solution {
    List<List<Integer>> answer = new ArrayList();
    List<Integer> temp = new ArrayList();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        dfs(candidates, target, 0);
        
        return answer;
    }
    
    private void dfs(int[] candidates, int target, int index) {
        if (target == 0) {
            answer.add(new ArrayList(temp));
            return;
        }
        
        
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                temp.add(candidates[i]);
                dfs(candidates, target - candidates[i], i);
                temp.remove(temp.size() -1);
            }
        }
    }
    
  
}
/*
cadidates 중복 x

combinations에서 수 중복 선택 가능, 전체가 겹치면 안됨
말이 조합이지 합을 나타내는 경우

1 <= candidates.length <= 30

1 2 2 3
2 2 2 2
길이도 같은 경우가 있다.


인덱스를 돌아올 수 없게 설정하면 된다.

*/