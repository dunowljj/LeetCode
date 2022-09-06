class Solution {
    public boolean isPalindrome(String s) {
        /* 
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        
        char[] reverse = new char[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            reverse[s.length() - 1 - i] = s.charAt(i);
        }
        
        return Arrays.equals(s.toCharArray(), reverse);
        */
        
        // improve speed
        int front = 0;
        int end = s.length() - 1;
        while (front <= end) {
            char frontCh = Character.toLowerCase(s.charAt(front));
            char endCh = Character.toLowerCase(s.charAt(end));
            
            if (!Character.isLetterOrDigit(frontCh)) {
                front++;
                continue;
            }
            
            if (!Character.isLetterOrDigit(endCh)) {
                end--;
                continue;
            }
            
            if (frontCh != endCh) {
                return false;
            } else {
                front++;
                end--;
            }
            
        }
        return true;
    }
}