import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville)
            pq.offer(i);
        
        while(pq.size()>1){
            int min = pq.poll();
            if(min>=K) break;
            int nxtMin = pq.poll();
            int newScovile = min+(nxtMin*2);
            answer++;
            pq.offer(newScovile);
        }
        
        return pq.poll()<K ? -1 : answer;
    }
}