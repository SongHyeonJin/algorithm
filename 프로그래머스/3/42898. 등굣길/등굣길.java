import java.util.*;

class Solution {
    static final int MOD = 1000000007;
    static int[][] memo;
    static int[][] puddles_map;
    static int dp(int n, int m) {
        if(m<1 || n<1 || puddles_map[n][m]==-1) return 0;
        
        if(m==1 && n==1) return 1;
        
        if(memo[n][m]!=-1) return memo[n][m];
        
        memo[n][m] = (dp(n, m-1)+dp(n-1, m))%MOD;
        
        return memo[n][m];
    }
    public int solution(int m, int n, int[][] puddles) {
        memo = new int[n+1][m+1];
        puddles_map = new int[n+1][m+1];
        
        for(int[] puddle : puddles) {
            puddles_map[puddle[1]][puddle[0]] = -1;
        }
        
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        
        return dp(n, m);
    }
}