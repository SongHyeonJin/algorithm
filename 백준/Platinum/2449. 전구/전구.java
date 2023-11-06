import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int INF = 1 << 30;
    static int n, k;
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        dp = new int[n+1][n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == arr[i-1]){
                n--;
                i--;
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] = INF;
            }
            dp[i][i] = 0;
        }

        for(int size=2; size<=n; size++){
            for(int start=1; start<=n-size+1; start++){
                int end = start+size-1;
                for(int mid=start; mid<end; mid++){
                    int newValue = dp[start][mid] + dp[mid+1][end] + (arr[start] != arr[mid+1] ? 1 : 0);
                    dp[start][end] = Math.min(dp[start][end], newValue);
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}
