class Solution {
    public int solution(int n) {
        int answer = 0;
        int nowCount = Integer.bitCount(n);
        
        while(true) {
            n++;
            int nxtCount = Integer.bitCount(n);
            
            if(nowCount==nxtCount) {
                answer = n;
                break;
            }
        }
        return answer;
    }
}