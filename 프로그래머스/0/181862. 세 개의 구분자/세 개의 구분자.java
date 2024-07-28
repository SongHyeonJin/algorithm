import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        List<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(char c : myStr.toCharArray()){
            if(c == 'a' || c == 'b' || c == 'c'){
                if(!sb.toString().equals("")) {
                    answer.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            }
            else sb.append(c);
        }
        if(!sb.toString().equals("")) answer.add(sb.toString());
        return answer.isEmpty() ? new String[]{"EMPTY"} : answer.stream().toArray(String[]::new);
    }
}