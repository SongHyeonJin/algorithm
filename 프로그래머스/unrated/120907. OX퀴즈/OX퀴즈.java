import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i=0; i<quiz.length; i++){
            String[] a = quiz[i].split(" ");
            int result = 0;
            for(int j=0; j<a.length; j++){
                if(a[j].equals("-"))
                    result = Integer.parseInt(a[0]) - Integer.parseInt(a[2]);
                else if(a[j].equals("+"))
                    result = Integer.parseInt(a[0]) + Integer.parseInt(a[2]);
                if(result == Integer.parseInt(a[4]))
                    answer[i] = "O";
                else
                    answer[i] = "X";
            }
        }
        return answer;
    }
}