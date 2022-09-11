class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        char[] ranArr = ransomNote.toCharArray();
        char[] magArr = magazine.toCharArray();
        
        Arrays.sort(ranArr);
        Arrays.sort(magArr);
        
        
        int idx = 0;
        int i = -1;
        while (++i < magArr.length) {
            if (ranArr[idx] == magArr[i]) {
                idx++;
            }    
            
            if (idx == ranArr.length) {
                return true;
            }
        }   

        return false;
    }
}

/*
can only be used once
*/