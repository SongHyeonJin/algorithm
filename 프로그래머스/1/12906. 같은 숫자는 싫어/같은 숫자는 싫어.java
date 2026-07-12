import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i : arr) {
            if (!stack.isEmpty() && stack.peek() == i) continue;
            stack.push(i);
        }
        
        int[] answer = new int[stack.size()];
        int idx = stack.size() - 1;
        while (!stack.isEmpty()) {
            answer[idx--] = stack.pop();
        }

        return answer;
    }
}