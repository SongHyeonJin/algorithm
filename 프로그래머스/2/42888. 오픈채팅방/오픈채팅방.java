import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        
        for(int i=0; i<record.length; i++) {
            String[] rec = record[i].split(" ");
            
            if(rec[0].equals("Enter")) {
                map.put(rec[1], rec[2]);
            } else if(rec[0].equals("Change")) {
                map.put(rec[1], rec[2]);
            }
        }
        
        for(int i=0; i<record.length; i++) {
            String[] rec = record[i].split(" ");
            
            if(rec[0].equals("Enter")) {
                answer.add(map.get(rec[1]) + "님이 들어왔습니다.");
            } else if(rec[0].equals("Leave")) {
                answer.add(map.get(rec[1]) + "님이 나갔습니다.");
            }
        }
        
        return answer.stream().toArray(String[]::new);
    }
}