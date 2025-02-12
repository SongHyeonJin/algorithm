import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int idx = 0;
        int len = jobs.length;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Time> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        
        
        while(!pq.isEmpty() || idx<len){
            for(; idx<len && jobs[idx][0]<=time; idx++){
                pq.offer(new Time(jobs[idx][0], jobs[idx][1]));
            }
            if(pq.isEmpty()) {
                time = jobs[idx][0];
            }
            else {
                Time t = pq.poll();
                time += t.time;
                answer += time - t.start;
            }
        }
        return answer/len;
    }
    static class Time {
        int start, time;
        public Time(int start, int time) {
            this.start = start;
            this.time = time;
        }
    }
}