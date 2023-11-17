import java.util.*;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        
        HashMap<String, String> map = new HashMap<>();
        
        for(String[] strings : db)
            map.put(strings[0], strings[1]);
        
        if(map.containsKey(id_pw[0]))
            if(map.get(id_pw[0]).equals(id_pw[1]))
                answer = "login";
            else
                answer = "wrong pw";
        else
            answer = "fail";
        return answer;
    }
}