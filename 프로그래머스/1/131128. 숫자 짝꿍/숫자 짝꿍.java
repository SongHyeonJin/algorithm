import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String X, String Y) {
        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();
        
        List<String> list = new ArrayList<>();
        
        for(String key : X.split(""))
            xMap.put(key, xMap.getOrDefault(key, 0)+1);
        
        for(String key : Y.split(""))
            yMap.put(key, yMap.getOrDefault(key, 0)+1);
        
        for(String key : xMap.keySet()){
            if(!yMap.containsKey(key)) continue;
            int length = Math.min(xMap.get(key), yMap.get(key));
            for(int i=0; i<length; i++)
                list.add(key);
        }
        
        String answer = list.stream()
            .sorted(Collections.reverseOrder())
            .collect(Collectors.joining());
        
        if(answer.isEmpty()) return "-1";
        if(answer.replaceAll("0", "").isEmpty()) return "0";
        return answer;
    }
}