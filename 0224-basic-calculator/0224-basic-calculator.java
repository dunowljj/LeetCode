import java.util.*;

class Solution {
    public int calculate(String s) {
        int n = s.length();

        Stack<Integer> stack = new Stack<>();
       
        int sum = 0;
        int operand = 0;
        int operator = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ('0' <= ch && ch <= '9') {
                operand = operand * 10 + (ch - '0');
            } else if (ch == ' ') {
                continue;
            } else if (ch == '(') {  
                stack.push(operator);
                stack.push(sum);
                operator = 1;
                sum = 0;
            } else if (ch == ')') {
                sum += operand * operator;
                operand = 0;
                int beforeSum = stack.pop();
                int beforeOp = stack.pop();
                sum = beforeSum + (beforeOp * sum);
            } else if (ch == '-') {
                sum += operator * operand;
                operand = 0;
                operator = -1;
            } else if (ch == '+') {
                sum += operator * operand;
                operand = 0;
                operator = 1;
            }
        }
        sum += operator * operand;
        return sum;
    }
}
/**

1+(4+5)

 */