import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> idx = new HashMap<>();
        
        for(int i=0; i<id_list.length; i++){
            map.put(id_list[i], new HashSet<>());
            idx.put(id_list[i], i);
        }
        
        for(int i=0; i<report.length; i++) {
            String[] sep = report[i].split(" ");
            map.get(sep[1]).add(sep[0]);
        }
        
        for(int i=0; i<id_list.length; i++) {
            HashSet<String> send = map.get(id_list[i]);
            if(send.size()>=k) {
                for(String name : send) {
                    answer[idx.get(name)]++;
                }
            }
        }
        return answer;
    }
}