class Solution {
    public String solution(int n) {
        String answer = "";        
        while(n > 0) {
            if(n % 3 == 0) {
                answer += "4";
                n = n/3 - 1;
            }
            if(n % 3 == 1) {
                answer += "1";
                n = n/3;
            }
            if(n % 3 == 2) {
                answer += "2";
                n = n/3;
            }
        }
        StringBuilder sb = new StringBuilder(answer);
        String reverse = sb.reverse().toString();
        
        return reverse;
    }
}
