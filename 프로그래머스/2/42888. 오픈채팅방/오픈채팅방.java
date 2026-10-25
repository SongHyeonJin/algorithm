import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> uidToNickname = new HashMap<>();
        List<String[]> actions = new ArrayList<>();
        
        for (String r : record) {
            String[] parts = r.split(" ");
            String cmd = parts[0];
            String uid = parts[1];
            
            if (!cmd.equals("Leave")) {
                String nickname = parts[2];
                uidToNickname.put(uid, nickname);
            }
            
            if (!cmd.equals("Change")) {
                actions.add(new String[]{cmd, uid});
            }
        }
        
        String[] answer = new String[actions.size()];
        for (int i = 0; i < actions.size(); i++) {
            String cmd = actions.get(i)[0];
            String uid = actions.get(i)[1];
            String nickname = uidToNickname.get(uid);
            
            if (cmd.equals("Enter")) {
                answer[i] = nickname + "님이 들어왔습니다.";
            } else if (cmd.equals("Leave")) {
                answer[i] = nickname + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}