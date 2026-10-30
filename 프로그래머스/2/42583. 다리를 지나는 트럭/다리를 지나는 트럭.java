import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridgeQueue = new ArrayDeque<>();
        
        for (int i = 0; i < bridge_length; i++) {
            bridgeQueue.offer(0);
        }
        
        int time = 0;
        int currentBridgeWeight = 0;
        int truckIdx = 0;
        
        while (truckIdx < truck_weights.length) {
            time++;
            
            currentBridgeWeight -= bridgeQueue.poll();
            
            int nextTruckWeight = truck_weights[truckIdx];
            
            if (currentBridgeWeight + nextTruckWeight <= weight) {
                bridgeQueue.offer(nextTruckWeight);
                currentBridgeWeight += nextTruckWeight;
                truckIdx++;
            } else {
                bridgeQueue.offer(0);
            }
        }
        
        return time + bridge_length;
    }
}