import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] str1, str2;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine().split("");
        str2 = br.readLine().split("");
        int oneLen  = str1.length;
        int twoLen  = str2.length;
        dp = new int[oneLen+1][twoLen+1];

        for (int i = 1; i <= oneLen; i++) {
            for (int j = 1; j <= twoLen; j++) {
                if (str1[i-1].equals(str2[j-1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println(dp[oneLen][twoLen]);
    }
}