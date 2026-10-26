import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {        
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        int maxHealth = health;
        int currentHealth = health;
        
        Map<Integer, Integer> attackMap = new HashMap<>();
        for (int[] attack : attacks) {
            attackMap.put(attack[0], attack[1]);
        }
        
        int lastAttackTime = attacks[attacks.length - 1][0];
        int continuousSuccess = 0;
        
        for (int time = 1; time <= lastAttackTime; time++) {
            if (attackMap.containsKey(time)) {
                currentHealth -= attackMap.get(time);
                continuousSuccess = 0;
                
                if (currentHealth <= 0) return -1;
            } else {
                continuousSuccess++;
                currentHealth += x;
                
                if (continuousSuccess == t) {
                    currentHealth += y;
                    continuousSuccess = 0;
                }
                
                if (currentHealth > maxHealth) {
                    currentHealth = maxHealth;
                }
            }
            
        }
        
        return currentHealth;
    }
}