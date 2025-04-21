import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> dic = new ArrayList<>();
        
        for(int i='A'; i<='Z'; i++) {
            dic.add(String.valueOf((char)i));
        }
        
        for(int i=0; i<msg.length(); i++) {
            for(int j=dic.size()-1; j>=0; j--) {
                if(msg.substring(i).startsWith(dic.get(j))) {
                    i += dic.get(j).length()-1;
                    answer.add(j+1);
                    if(i+1<msg.length()) {
                        dic.add(dic.get(j)+msg.charAt(i+1));
                    }
                    break;
                }
            }
        }
        
        return answer.stream().mapToInt(n -> n).toArray();
    }
}