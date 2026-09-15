import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        long totalSum = 0;
        
        for (int num : queue1) {
            q1.add((long) num);
            sum1 += num;
        }
        
        for (int num : queue2) {
            q2.add((long) num);
            sum2 += num;
        }
        
        totalSum = sum1 + sum2;
        
        if (totalSum % 2 != 0) return -1;
        
        long target = totalSum / 2;
        int maxCount = (queue1.length + queue2.length) * 2;
        int count = 0;
        
        while (count <= maxCount) {
            if (sum1 == target) return count;
            
            if (sum1 > target) {
                long val = q1.poll();
                sum1 -= val;
                sum2 += val;
                q2.add(val);
            } else {
                long val = q2.poll();
                sum2 -= val;
                sum1 += val;
                q1.add(val);
            }
            count++;
        }
        
        return -1;
    }
}