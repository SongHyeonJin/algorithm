import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int prevIndex = stack.pop();
                
                answer[prevIndex] = i - prevIndex; 
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int prevIndex = stack.pop();
            answer[prevIndex] = n - 1 - prevIndex;
        }
        
        return answer;
    }
}