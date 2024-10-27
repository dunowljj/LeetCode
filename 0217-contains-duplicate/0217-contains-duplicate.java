import java.util.*;

class Solution {
    
    
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> checker = new HashSet<>();
        
        for (int num : nums) {
            if (checker.contains(num)) return true;
            else checker.add(num);
        }

        return false;
    }
}