import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, max;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        max = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}