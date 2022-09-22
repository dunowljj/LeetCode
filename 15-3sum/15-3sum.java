class Solution {
    List<List<Integer>> answer;
    Map<Integer, Integer> map = new HashMap();
    public List<List<Integer>> threeSum(int[] nums) {
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        Arrays.sort(nums);
        
        answer = new ArrayList();
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        
        dfs(0, 0, 0, arr, nums);

        return answer.stream().distinct().collect(Collectors.toList());
    }
    
    public void dfs(int depth, int sum, int idx, int[] arr, int[] nums) {
        if (depth == 2) {
            Integer key = 0 - sum;
            if (map.getOrDefault(key, 0) > 0) {
                arr[2] = 0 - sum;
                answer.add(Arrays.stream(arr).sorted().boxed().toList()); 
            }
            return;
        }
        
        int before = -10_001;
        for (int i = idx; i < nums.length; i++) {
            int num = nums[i];
            
            if (before == num) continue;
            
            arr[depth] = num;
            map.put(num, map.get(num) - 1);
            before = num;
            dfs(depth + 1, sum + num, i + 1, arr, nums);
            
            map.put(num, map.get(num) + 1);
        }
    }
}
/*
길이가 3이고 합이 0 인 triplets 구하기. 중복 금지
dfs를 하면서 인덱스도 같이 증가시키면 된다. -> 중복 요소가 등장 가능하기 때문에 추가 중복 제거가 필요
1) stream의 distinct
2) nums를 정렬하고, 같은 자리에 중복요소가 올 수 없도록 조치한다. -> 채택

-10^5 <= nums <= 10^5 
길이가 최대 3천... dfs시 27억가지
2개를 찾고 Set으로 찾는다면? -> 중복 요소가 우수수 걸린다. 여러개인지 세어보려면 Map이 필요하다.
*/