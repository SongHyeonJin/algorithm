import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        Deque<Integer> priceIndexStack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            while (!priceIndexStack.isEmpty() && prices[i] < prices[priceIndexStack.peek()]) {
                int previousIndex = priceIndexStack.pop();
                answer[previousIndex] = i - previousIndex;
            }
            
            priceIndexStack.push(i);
        }
        
        while (!priceIndexStack.isEmpty()) {
            int previousIndex = priceIndexStack.pop();
            answer[previousIndex] = n - 1 - previousIndex;
        }
        
        return answer;
    }
}