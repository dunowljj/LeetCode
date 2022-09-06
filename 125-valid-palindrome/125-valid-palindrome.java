class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        
        char[] reverse = new char[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            reverse[s.length() - 1 - i] = s.charAt(i);
        }
        
        return Arrays.equals(s.toCharArray(), reverse);
    }
}