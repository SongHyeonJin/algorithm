import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[][] bag;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bag = new int[n+1][2];
        dp = new int[n+1][k+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            bag[i][0] = Integer.parseInt(st.nextToken());
            bag[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                if (bag[i][0] <= j)
                    dp[i][j] = Math.max(dp[i-1][j-bag[i][0]]+bag[i][1], dp[i][j]);
            }
        }
        System.out.println(dp[n][k]);
    }
}
