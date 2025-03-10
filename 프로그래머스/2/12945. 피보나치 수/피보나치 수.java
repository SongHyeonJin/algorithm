class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] fn = new int[n+1];
        
        fn[0] = 0;
        fn[1] = 1;
        for(int i=2; i<=n; i++) {
            fn[i] = (fn[i-1] + fn[i-2])%1234567;
        }
        answer = fn[n];
        return answer;
    }
}