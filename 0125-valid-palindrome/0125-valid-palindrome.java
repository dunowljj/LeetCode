class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase()
            .replaceAll("[^a-zA-z0-9]", "")
            .toCharArray();

        System.out.println(arr);
        
        return isPalindrome(arr);
    }

    public boolean isPalindrome(char[] arr) {
        int len = arr.length;

        for (int i = 0; i < len / 2; i++) {
            if (arr[i] != arr[(len - 1 - i)]) {
                return false;
            }
        }   
        return true;
    }
}