import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(int i : works) {
            pq.add(i);
        }
        
        while(n-- > 0) {
            int num = pq.poll();
            if(num>=pq.peek()) pq.add(num-1);
        }
        
        if(pq.peek()<=0) return 0;
        
        while(!pq.isEmpty()) {
            answer += (long)Math.pow(pq.poll(),2);
        }
        return answer;
    }
}