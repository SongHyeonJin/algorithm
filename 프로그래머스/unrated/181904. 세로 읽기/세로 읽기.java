import java.util.*;

class Solution {
    public String solution(String my_string, int m, int c) {
        List<String> list = new ArrayList<>();
        for(int i=0; i<my_string.length(); i+=m){
            String str = my_string.substring(i, i+m);
            list.add(str);
        }
        String answer = "";
        for(String s : list)
            answer +=  s.substring(c-1, c);
        return answer;
    }
}