import java.util.*;

class Solution {
    public String solution(int age) {
        String answer = "";
        Map<Character, Character> map = new HashMap<>();
        map.put('0', 'a');
        map.put('1', 'b');
        map.put('2', 'c');
        map.put('3', 'd');
        map.put('4', 'e');
        map.put('5', 'f');
        map.put('6', 'g');
        map.put('7', 'h');
        map.put('8', 'i');
        map.put('9', 'j');
        String str = String.valueOf(age);
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            answer += map.get(c);
        }
        return answer;
    }
}