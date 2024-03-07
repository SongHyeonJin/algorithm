import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<keymap.length; i++)
            for(int j=0; j<keymap[i].length(); j++){
                char c = keymap[i].charAt(j);
                if(map.containsKey(c)){
                    int index = map.get(c);
                    map.put(c, Math.min(index, j+1));
                }else
                    map.put(c, j+1);
            }
        
        for(int i=0; i<targets.length; i++){
            String target = targets[i];
            int count = 0;
            boolean flag = true;
            for(char c : target.toCharArray()){
                if(map.containsKey(c))
                    count += map.get(c);
                else{
                    flag = false;
                    break;
                }
            }
            answer[i] = flag == false ? -1 :count;
        }
        return answer;
    }
}