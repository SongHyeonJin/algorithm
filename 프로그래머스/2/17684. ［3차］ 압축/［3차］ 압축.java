import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<String> dictionary = initDictionary();
        List<Integer> answer = new ArrayList<>();
        
        int currentIndex = 0;
        
        while (currentIndex < msg.length()) {
            String longestWord = "";
            int longestIndex = -1;
            
            for (int i = dictionary.size() - 1; i >= 0; i--) {
                String word = dictionary.get(i);
                if (msg.startsWith(word, currentIndex)) {
                    longestWord = word;
                    longestIndex = i + 1;
                    break;
                }
            }
            
            answer.add(longestIndex);
            currentIndex += longestWord.length();
            
            if (currentIndex < msg.length()) {
                char nextChar = msg.charAt(currentIndex);
                dictionary.add(longestWord + nextChar);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private List<String> initDictionary() {
        List<String> dictionary = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.add(String.valueOf(c));
        }
        return dictionary;
    }
}