import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] n = br.readLine().split("");
        String[] m =  br.readLine().split("");
        int[][] dp = new int[n.length+1][m.length+1];

        for (int i = 1; i <= n.length; i++) {
            for (int j = 1; j <= m.length; j++) {
                if (n[i-1].equals(m[j-1]))
                    dp[i][j] = dp[i-1][j-1]+1;
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[n.length][m.length]);
    }
}