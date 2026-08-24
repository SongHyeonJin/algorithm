import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        int[][] times = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = convertToMinute(book_time[i][0]);
            times[i][1] = convertToMinute(book_time[i][1]) + 10; 
        }
        
        Arrays.sort(times, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int[] time : times) {
            if (!pq.isEmpty() && pq.peek() <= time[0]) {
                pq.poll();
            }
            
            pq.add(time[1]);
        }
        
        return pq.size();
    }
    
    private int convertToMinute(String timeStr) {
        String[] parts = timeStr.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 60 + minute;
    }
}