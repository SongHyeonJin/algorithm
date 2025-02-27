import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<>();
        
        int out=1, cycle=1;
        for(int i=0; i<words.length; i++) {
            if(list.contains(words[i])) {
                answer[0] = out;
                answer[1] = cycle;
                break;
            }
            if(!list.isEmpty() && list.get(i-1).charAt(list.get(i-1).length()-1)!=words[i].charAt(0)){
                answer[0] = out;
                answer[1] = cycle;
                break;
            }
            if(out==n) {
                out=1;
                cycle++;
            } else {
                out++;
            }
            list.add(words[i]);
        }
        if(list.size()==words.length) {
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}