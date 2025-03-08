import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> yB = new HashMap<>();
        Map<Integer, Integer> oB = new HashMap<>();
        
        for(int t : topping) {
            yB.put(t, yB.getOrDefault(t, 0)+1);
        }
        
        for(int t : topping) {
            oB.put(t, oB.getOrDefault(t, 0)+1);
            
            if(yB.get(t)-1==0) {
                yB.remove(t);
            } 
            else {
                yB.put(t, yB.get(t)-1);
            }
            
            if(yB.size()==oB.size()) answer++;
        }
       
        return answer;
    }
}