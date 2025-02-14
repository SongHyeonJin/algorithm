class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] fn = new long[2001];
        
        fn[1] = 1;
        fn[2] = 2;
        for(int i=3; i<2001; i++) {
            fn[i] = (fn[i-1] + fn[i-2])%1234567;
        }
        answer = fn[n];
        return answer;
    }
}