import java.util.*;

class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        
        for (int curr = 0; curr < height.length; curr++) {
            
            // 이전 bar(peek) 높이보다 현재 bar 높이가 높다면, 이전 bar위의 trapping water 계산을 시도한다.
            while (!stack.isEmpty() && height[stack.peek()] < height[curr]) {
                int pop = stack.pop();

                // pop한 위치보다 왼쪽에 있는 부분에 bar가 없다면 trapping water가 발생하지 않는다.
                // pop한 bar보다 더큰 bar가 바로 우측(curr)에 존재하므로, trapping water계산에 pop한 bar는 더 이상 필요 없다.
                if (stack.isEmpty()) break;
                
                int temp_height = Math.min(height[stack.peek()], height[curr]) - height[pop];
                int width = curr - stack.peek() - 1;
 
                sum += temp_height * width;
            }
            stack.push(curr);
        }

        return sum;
    }
}