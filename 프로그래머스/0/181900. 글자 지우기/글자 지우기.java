import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        String[] word = my_string.split("");
        
        
        for(int i=0; i<indices.length; i++){
            word[indices[i]] = "";
        }
        
        for(String s : word)
            answer += s;
        return answer;
    }
}