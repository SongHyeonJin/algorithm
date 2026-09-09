import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        int time = 0;
        int currentWeight = 0;
        int truckIndex = 0;
        
        while (truckIndex < truck_weights.length) {
            time++;
            
            currentWeight -= bridge.poll();
            
            int nextTruck = truck_weights[truckIndex];
            if (currentWeight + nextTruck <= weight) {
                bridge.add(nextTruck);
                currentWeight += nextTruck;
                truckIndex++;
            } else {
                bridge.add(0);
            }
        }
        
        return time + bridge_length;
    }
}