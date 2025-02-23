class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; sb.length()<=t*m; i++) {
            sb.append(Integer.toString(i, n));
        }
        
        for(int i=p-1; answer.length()<t; i+=m) {
            answer += sb.charAt(i);
        }
        
        return answer.toUpperCase();
    }
}