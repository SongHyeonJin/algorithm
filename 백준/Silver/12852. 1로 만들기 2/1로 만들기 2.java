import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] dp, path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        path = new int[N+1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 0;
        for(int i=2; i<= N; i++){
            if(i%3 == 0){
                if(dp[i/3] + 1 < dp[i]){
                    dp[i] = dp[i/3] + 1;
                    path[i] = i/3;
                }
            }
            if(i%2 == 0){
                if(dp[i/2] + 1 < dp[i]){
                    dp[i] = dp[i/2] + 1;
                    path[i] = i/2;
                }
            }
            if(dp[i-1] + 1 < dp[i]){
                dp[i] = dp[i-1] + 1;
                path[i] = i - 1;
            }
        }
        sb.append(dp[N]).append("\n");
        while (N > 0){
            sb.append(N).append(" ");
            N = path[N];
        }
        System.out.println(sb);
    }
}