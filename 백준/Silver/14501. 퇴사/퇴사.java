import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, answer = Integer.MIN_VALUE;
    static int[][] interview;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        interview = new int[n][2];
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            interview[i][0] = Integer.parseInt(st.nextToken());
            interview[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(dp[0]);
    }
    static int dfs(int idx){
        if (idx == n) return 0;
        if (idx > n-1) return Integer.MIN_VALUE;
        if (dp[idx] != -1) return dp[idx];
        dp[idx] = Math.max(dfs(idx+ interview[idx][0])+interview[idx][1], dfs(idx+1));
        return dp[idx];
    }
}
