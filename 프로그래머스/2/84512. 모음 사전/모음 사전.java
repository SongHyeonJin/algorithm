class Solution {
    public int solution(String word) {
        int answer = 0;
        String vowels = "AEIOU";
        
        for (int i = 0; i < word.length(); i++) {
            int index = vowels.indexOf(word.charAt(i));
            
            int weight = 0;
            for (int j = 0; j < 5 - i; j++) {
                weight += Math.pow(5, j);
            }
            
            answer += index * weight + 1;
        }
        
        return answer;
    }
}