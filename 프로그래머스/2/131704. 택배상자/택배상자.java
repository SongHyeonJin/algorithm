import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0, n = order.length;
        int[] priority = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<n; i++) {
            priority[order[i] - 1] = i;
        }
        
        for(int i=0; i<n; i++) {
            if (priority[i] == answer) {
                answer++;
            } else {
                stack.push(priority[i]);
            }
            
            while(!stack.isEmpty() && stack.peek() == answer) {
                stack.pop();
                answer++;
            }
        }
        
        return answer;
    }
}