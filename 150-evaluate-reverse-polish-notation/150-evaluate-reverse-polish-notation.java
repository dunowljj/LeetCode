class Calculator {
    private static char symbol;
    
    private Calculator(char input) {
        this.symbol = input;
    }
    
    static Calculator from(String token) {
        return new Calculator(token.charAt(0));
    }
    
    static int operate(int operand1, int operand2) {
        if (symbol == '+') {
            return operand1 + operand2;
        }
        
        if (symbol == '-') {
            return operand1 - operand2;
        }
        
        if (symbol == '*') {
            return operand1 * operand2;
        }
        
        if (symbol == '/') {
            return operand1 / operand2;
        }
        
        return 0;
    }
    
}

class Solution {
        
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack();
        
        for (int i = 0; i < tokens.length; i++) {
            try {
                numbers.push(Integer.parseInt(tokens[i]));  
            
            // 숫자로 변환 안되는 경우 -> 연산자    
            } catch (NumberFormatException e) {
                int operand2 = numbers.pop();
                int operand1 = numbers.pop();
                
                int result = Calculator.from(tokens[i]).operate(operand1, operand2);
                numbers.push(result);
            }
        }
        
        return numbers.pop();
    }
}