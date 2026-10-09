class Solution {
    public int solution(int n, int[] money) {
        int mod = 1000000007;
        
        long[] dp = new long[n + 1];
        
        dp[0] = 1;
        
        for (int coin : money) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % mod;
            }
        }
        
        return (int) dp[n];
    }
}