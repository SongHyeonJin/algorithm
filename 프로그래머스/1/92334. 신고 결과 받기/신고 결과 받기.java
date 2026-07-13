import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> users = new HashMap();
        Map<String, Integer> idx = new HashMap<>();
        
        for(int i=0; i<id_list.length; i++) {
            users.put(id_list[i], new HashSet<>());
            idx.put(id_list[i], i);
        }
        
        for(String s : report) {
            String[] person = s.split(" ");
            users.get(person[1]).add(person[0]);
        }
        
        for(String person : id_list) {
            HashSet<String> send = users.get(person);
            if (send.size() >= k) {
                for(String name : send) answer[idx.get(name)]++;
            }
        }
        
        return answer;
    }
}