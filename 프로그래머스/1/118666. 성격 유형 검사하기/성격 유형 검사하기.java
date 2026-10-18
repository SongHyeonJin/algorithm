import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> scores = new HashMap<>();
        
        for (int i = 0; i < survey.length; i++) {
            char disagreeChar = survey[i].charAt(0);
            char agreeChar = survey[i].charAt(1);
            int choice = choices[i];
            
            if (choice < 4) {
                scores.put(disagreeChar, scores.getOrDefault(disagreeChar, 0) + (4 - choice));
            } else if (choice > 4) {
                scores.put(agreeChar, scores.getOrDefault(agreeChar, 0) + (choice - 4));
            }
        }
        
        StringBuilder answer = new StringBuilder();
        
        answer.append(scores.getOrDefault('R', 0) >= scores.getOrDefault('T', 0) ? 'R' : 'T');
        
        answer.append(scores.getOrDefault('C', 0) >= scores.getOrDefault('F', 0) ? 'C' : 'F');
        
        answer.append(scores.getOrDefault('J', 0) >= scores.getOrDefault('M', 0) ? 'J' : 'M');
        
        answer.append(scores.getOrDefault('A', 0) >= scores.getOrDefault('N', 0) ? 'A' : 'N');
        
        return answer.toString();
    }
}