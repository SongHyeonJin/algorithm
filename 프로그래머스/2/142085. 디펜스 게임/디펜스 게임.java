import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int sumEnemy = 0;
        
        for (int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]);
            sumEnemy += enemy[i];
            
            if (sumEnemy > n) {
                if (k > 0) {
                    sumEnemy -= pq.poll();
                    k--;
                } else {
                    return i;
                }
            }
        }
        
        return enemy.length;
    }
}