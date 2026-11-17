import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> youngerMap = new HashMap<>();
        Set<Integer> elderSet = new HashSet<>();
        
        for (int t : topping) {
            youngerMap.put(t, youngerMap.getOrDefault(t, 0) + 1);
        }
        
        for (int t : topping) {
            elderSet.add(t);
            
            youngerMap.put(t, youngerMap.get(t) - 1);
            
            if (youngerMap.get(t) == 0) {
                youngerMap.remove(t);
            }
            
            if (elderSet.size() == youngerMap.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}