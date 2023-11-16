import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
//         Arrays.sort(participant);
//         Arrays.sort(completion);
        
//         int i=0;
//         for(; i<completion.length; i++){
//             if(!completion[i].equals(participant[i])){
//                 break;
//             }
//         }
//         answer = participant[i];
        
//         return answer;
        
        // HashMap 사용
        HashMap<String, Integer> map = new HashMap<>();

        // 참여자 명단을 HashMap에 추가
        for(String player : participant){
            map.put(player, map.getOrDefault(player, 0)+1);
        }

        // 완주자 명단을 HashMap에서 제거
        for(String player : completion){
            map.put(player, map.get(player)-1);
        }

        // HashMap에 남은 이름이 미완주자 이름
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        
        while(iter.hasNext()){
            Map.Entry<String, Integer> entry =  iter.next();
            if(entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }
        
        return answer;
    }
}