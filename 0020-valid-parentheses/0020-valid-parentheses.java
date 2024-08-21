import java.util.*;

class Solution {
    private final List<Character> open = List.of('(', '[', '{');
    private final List<Character> close = List.of(')', ']', '}');

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if (close.contains(s.charAt(0))) {
            return false;
        }

        for (Character ch : s.toCharArray()) {
            
            if (open.contains(ch)) {
                stack.push(ch);
                continue;
            }

            if (close.contains(ch)) {
                System.out.println("close");
                if (stack.isEmpty()) {
                    return false;
                }
                
                if (!stack.isEmpty() && open.indexOf(stack.peek()) != close.indexOf(ch)) {
                    return false;
                }

                stack.pop();
                continue;
            }
        }

        return stack.isEmpty();
    }
}

// ([)]