import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int n = book_time.length;
        int[][] reservations = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            reservations[i][0] = convertToMinute(book_time[i][0]);
            reservations[i][1] = convertToMinute(book_time[i][1]) + 10;
        }
        
        Arrays.sort(reservations, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]); 
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int[] reservation : reservations) {
            int startTime = reservation[0];
            int endTime = reservation[1];
            
            if (!pq.isEmpty() && pq.peek() <= startTime) {
                pq.poll();
            }
            
            pq.add(endTime);
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