import java.util.*;

class Solution {
    private static final int DEFAULT_OUT_TIME = 23 * 60 + 59;

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTimeMap = new HashMap<>();
        Map<String, Integer> totalTimeMap = new HashMap<>();
        
        for (String record : records) {
            String[] tokens = record.split(" ");
            int currentTime = convertToMinutes(tokens[0]);
            String carNumber = tokens[1];
            String ioType = tokens[2];
            
            if (ioType.equals("IN")) {
                inTimeMap.put(carNumber, currentTime);
            } else if (ioType.equals("OUT")) {
                int startTime = inTimeMap.get(carNumber);
                inTimeMap.remove(carNumber);
                
                int parkingTime = currentTime - startTime;
                totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + parkingTime);
            }
        }
        
        for (String carNumber : inTimeMap.keySet()) {
            int startTime = inTimeMap.get(carNumber);
            int parkingTime = DEFAULT_OUT_TIME - startTime;
            
            totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + parkingTime);
        }
        
        List<String> carList = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(carList);
        
        int[] answer = new int[carList.size()];
        for (int i = 0; i < carList.size(); i++) {
            String carNumber = carList.get(i);
            int totalTime = totalTimeMap.get(carNumber);
            answer[i] = calculateFee(fees, totalTime);
        }
        
        return answer;
    }
    
    private int convertToMinutes(String timeStr) {
        String[] parts = timeStr.split(":");
        int hour = Integer.parseInt(parts[0]) * 60;
        int minute = Integer.parseInt(parts[1]);
        return hour + minute;
    }
    
    private int calculateFee(int[] fees, int totalTime) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        if (totalTime <= basicTime) {
            return basicFee;
        }
        
        int excessTime = totalTime - basicTime;
        int chargedUnits = (excessTime + unitTime - 1) / unitTime;
        
        return basicFee + (chargedUnits * unitFee);
    }
}