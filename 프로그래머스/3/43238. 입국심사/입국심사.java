import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) times[times.length - 1] * n;
        long answer = right;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long processed = 0;
            
            for (int time : times) {
                processed += mid / time;
                
                if (processed >= n) {
                    break;
                }
            }
            
            if (processed >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}