class Solution {
    public boolean isValid(String s) {
        Stack<Character> bracket = new Stack();
        
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (curr == '(' || curr == '{' || curr == '[') {
                bracket.push(curr);            
            }
            
            if (curr == ')') {
                if (bracket.isEmpty()) {
                    return false;  
                }
                
                if (bracket.peek() == '(') {
                    bracket.pop();
                } else {
                    return false;
                }
            }
            
            if (curr == '}') {
                if (bracket.isEmpty()) {
                    return false;  
                }
                
                if (bracket.peek() == '{') {
                    bracket.pop();
                } else {
                    return false;
                }
            }
            
            if (curr == ']') {
                if (bracket.isEmpty()) {
                    return false;  
                }
                
                if (bracket.peek() == '[') {
                    bracket.pop();
                } else {
                    return false;
                }
            }
            
            
        }
        
        return bracket.isEmpty();
    }
}
/*
Open brackets must be closed in the correct order.
*/

