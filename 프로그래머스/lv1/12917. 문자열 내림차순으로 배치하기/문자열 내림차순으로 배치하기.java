import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strings = s.split("");
        Arrays.sort(strings, Collections.reverseOrder());
        for(int i=0; i<strings.length; i++){
            answer += strings[i];
        }
        return answer;
    }
}