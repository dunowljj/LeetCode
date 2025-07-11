class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        
        for (int curr = 0; curr < height.length; curr++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[curr]) {
                int top = stack.pop();

                if (stack.isEmpty()) break;
                
                int temp_height = Math.min(height[curr], height[stack.peek()]) - height[top];
                int width = curr - stack.peek() - 1;
 
                sum += temp_height * width;
            }
            stack.push(curr);
        }

        return sum; 
    }
}
//stk 1 0 
//hei 1 0 2 1 0 1 3
//idx 0 1 2 3 4 5 6
/*
풀이 1 brute force
O(N^2)으로 한 인덱스의 물의양을 각각 계산한다.
1) height의 처음부터 전체를 순회한다.
2) 각 인덱스의 지점에 대해서 양쪽(왼쪽, 오른쪽)으로 나눈다. 왼쪽에서의 최대 높이, 오른쪽에서의 최대높이를 구한다.
3) 양쪽 최대 높이 중 작은 값이 해당지점에 차오를 수 있는 물이다. 거기서 해당 지점의 높이를 뺴버리면 "해당 지점의 물의 양이다."

풀이 2 dp
풀이 1에서는 각각의 요소에서 양쪽 최고 높이를 모두 탐색했다. 이 최고 높이를 저장해서 해결한다.

풀이 3 스택
1) 처음 부터 순회하면서 각 높이를 스택에 추가한다.
2) 각 높이를 스택에 넣기 전에, 스택에 최신 높이와 현재 높이를 비교한다.
3-1) 스택의 최신 높이가 더 높은 경우 아무것도 하지 않는다.
3-2) 현재 높이가 더 높은 경우 스택을 pop하여 top 변수에 저장하고, 해당 상태에서 최신 높이와 top의 차이를 통해서 가로 한 줄의 물의 양을 구한다.
4) 반복

풀이 4 포인터 두개


높이가 나온 후, 자신보다 작은 높이가 한 번 이상 나온 후, 자신과 같거나 큰 막대가 나오면 사이에 물이 들어갈 수 있다.
두 막대 중 더 작은 값을 기준으로 물의 양을 계산해야 한다.
*/