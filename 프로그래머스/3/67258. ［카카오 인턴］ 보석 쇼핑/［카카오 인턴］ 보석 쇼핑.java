import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        int kind = new HashSet<>(List.of(gems)).size();
        int start=0, length=Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        
        for(int end=0; end<gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0)+1);
            
            while(map.get(gems[start])>1) {
                map.put(gems[start], map.get(gems[start])-1);
                start++;
            }
                
            if(kind==map.size() && length>(end-start)) {
                length = (end-start);
                answer[0] = start+1;
                answer[1] = end+1;
            }
        }
        
        return answer;
    }
}