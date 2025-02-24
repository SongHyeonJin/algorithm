class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(s.length()>1) {
            int cnt=0;
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i)=='0') {
                    answer[1]++;
                }
                else {
                    cnt++;
                }
            }
            s = Integer.toString(cnt, 2);
            answer[0]++;
        }
        
        return answer;
    }
}