import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        Deque<Integer> dq = new LinkedList<>();
        
        for(int i : numbers) dq.offerLast(i);
        
        if (direction.equals("right")) {
            dq.offerFirst(dq.pollLast());
        } else {
            dq.offerLast(dq.pollFirst());
        }
        
        int idx = 0;
        while (!dq.isEmpty()) {
            answer[idx++] = dq.pollFirst();
        }
        
        return answer;
    }
}