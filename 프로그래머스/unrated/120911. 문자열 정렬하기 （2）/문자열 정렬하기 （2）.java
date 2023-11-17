import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] a = my_string.split("");
        for(int i=0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            if(Character.isUpperCase(c))
                a[i] = a[i].toLowerCase();
            else 
                a[i] = a[i];
        }
        Arrays.sort(a);
        for(String c : a)
            answer += c;
        return answer;
    }
}