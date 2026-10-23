import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players.clone();
        Map<String, Integer> rank = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }
        
        for(String calling : callings) {
            int idx = rank.get(calling);
            String frontPlayer = answer[idx - 1];
            
            if (idx > 0) {
                rank.replace(frontPlayer, idx);
                rank.replace(calling, idx - 1);

                answer[idx] = frontPlayer;
                answer[idx - 1] = calling;   
            }
        }
        
        return answer;
    }
}