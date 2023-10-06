class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        for(int i=code; i<=cipher.length(); ){
            answer += cipher.charAt(i-1);
            i+=code;
        }
        return answer;
    }
}