import java.util.*;

class Solution {
    public List solution(String[] strArr) {
        List<String> answer = new ArrayList<>();
        for(int i=0; i<strArr.length; i++){
            if(strArr[i].contains("ad"))
                continue;
            answer.add(strArr[i]);
        }
        return answer;
    }
}