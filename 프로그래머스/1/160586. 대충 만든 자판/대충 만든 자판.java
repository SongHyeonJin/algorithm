import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> minPressMap = new HashMap<>();
        
        for (String keys : keymap) {
            for (int i = 0; i < keys.length(); i++) {
                char targetChar = keys.charAt(i);
                int pressCount = i + 1;
                
                minPressMap.put(
                    targetChar, 
                    Math.min(minPressMap.getOrDefault(targetChar, pressCount), pressCount)
                );
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            int totalPressCount = 0;
            boolean isPossible = true;
            
            for (char targetChar : targets[i].toCharArray()) {
                if (minPressMap.containsKey(targetChar)) {
                    totalPressCount += minPressMap.get(targetChar);
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            answer[i] = isPossible ? totalPressCount : -1;
        }
        
        return answer;
    }
}