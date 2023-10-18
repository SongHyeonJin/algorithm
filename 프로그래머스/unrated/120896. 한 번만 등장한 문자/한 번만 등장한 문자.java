import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strs = s.split("");
        
        Arrays.sort(strs);
        
        for(int i=0; i<strs.length; i++){
            int count = 0;
            for(int j=0; j<strs.length; j++){
                if(strs[i].equals(strs[j])) count++;
            }   
            if(count == 1) answer += strs[i];
        }
        return answer;
    }
}