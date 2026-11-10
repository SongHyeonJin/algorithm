class Solution {
    public int[] solution(int target) {
        int[][] dp = new int[target + 1][2];
        
        for (int i = 1; i <= target; i++) {
            dp[i][0] = 1000000;
            dp[i][1] = -1;
        }
        
        dp[0][0] = 0;
        dp[0][1] = 0;
        
        for (int i = 0; i < target; i++) {
            if (dp[i][0] == 1000000) continue;
            
            if (i + 50 <= target) {
                updateDp(dp, i + 50, dp[i][0] + 1, dp[i][1] + 1);
            }
            
            
            for (int score = 1; score <= 20; score++) {
                
                if (i + score <= target) {
                    updateDp(dp, i + score, dp[i][0] + 1, dp[i][1] + 1);
                }
                
                if (i + score * 2 <= target) {
                    updateDp(dp, i + score * 2, dp[i][0] + 1, dp[i][1]);
                }
                
                if (i + score * 3 <= target) {
                    updateDp(dp, i + score * 3, dp[i][0] + 1, dp[i][1]);
                }
            }
        }
        
        return dp[target];
    }
    
    private void updateDp(int[][] dp, int next, int count, int singleBullCount) {
        if (dp[next][0] > count) {
            dp[next][0] = count;
            dp[next][1] = singleBullCount;
        } else if (dp[next][0] == count) {
            if (dp[next][1] < singleBullCount) {
                dp[next][1] = singleBullCount;
            }
        }
    }
}