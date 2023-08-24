import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, min;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;

        solve(N);
        System.out.println(dp[N]);
    }
    static void solve(int N){
        for(int i=2; i<=N; i++){
            min = Integer.MAX_VALUE;
            for(int j=1; j*j<=i; j++){
                min = Math.min(min, dp[i-j*j]);
            }
            dp[i] = min + 1;
        }
    }
}