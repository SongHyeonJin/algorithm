class Solution {
    public String solution(String letter) {
        String[] morse = {
            ".-","-...","-.-.","-..",".","..-.","--.",
            "....","..",".---","-.-",".-..","--","-.",
            "---",".--.","--.-",".-.","...","-","..-",
            "...-",".--","-..-","-.--","--.."
        };
        String[] strings = letter.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word : strings){
            for(int i=0; i<morse.length; i++){
                if(word.equals(morse[i])) sb.append(Character.toString(i+'a'));
            }
        }
        return sb.toString();
    }
}