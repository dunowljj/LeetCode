class Calculator {
    private static char symbol;
    
    private Calculator(char input) {
        this.symbol = input;
    }
    
    static Calculator from(char symbol) {
        return new Calculator(symbol);
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
    Stack<Integer> numbers = new Stack();
        
    public int evalRPN(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            char curr = tokens[i].charAt(0);
            
            // -인 경우
            try {
                numbers.push(Integer.parseInt(tokens[i]));    
            } catch (NumberFormatException e) {
                int operand2 = numbers.pop();
                int operand1 = numbers.pop();
                
                int result = Calculator.from(curr).operate(operand1, operand2);
                numbers.push(result);
            }
        }
        
        return numbers.pop();
    }
}