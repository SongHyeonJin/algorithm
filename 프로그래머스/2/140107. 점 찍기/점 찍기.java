class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (long x = 0; x <= d; x += k) {
            long maxD = (long) d * d;
            long maxX = x * x;
            long maxY = maxD - maxX;
            
            long limitY = (long) Math.sqrt(maxY);
            
            answer += (limitY / k) + 1;
        }
        
        return answer;
    }
}