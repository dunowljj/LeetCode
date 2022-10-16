class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList();

    int n = nums.length;
    int nthBit = 1 << n;
    
    for (int i = 0; i < (int)Math.pow(2, n); i++) {
        // 맨 앞의 0이 사라지는걸 방지하기 위해, 최대자릿수 + 1에 비트를 추가했다가 제거한다.
        String bitmask = Integer.toBinaryString(i | nthBit).substring(1); 
        
        List<Integer> list = new ArrayList();
        for (int j = 0 ; j < bitmask.length(); j++) {
            if (bitmask.charAt(j) == '1') list.add(nums[j]);
        }
        
        output.add(list);
    }
      

      
    return output;
  }
}