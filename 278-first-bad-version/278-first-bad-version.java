/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int start = 1;
        int end = n;
        int middle = 1;
        while (start < end) {            
            
            middle = start + (end - start) / 2;
            
            if (isBadVersion(middle)) {                
                end = middle;
                
            } else { 
                start = middle + 1;
            }   

        }
        
        return start;
    }
}
/*

start 1
middle 2
end 3
---
1 2(bad) 3 ->  start 1, end 1 -> 1,1  -> is bad? or not? 
1 4(bad) 7 -> 1 2(not) 3 -> 3 3 -> 3,3 is bad? or not?


1,2 -> 1 1 2 
bad -> 1, 1
not -> 2, 2




*/