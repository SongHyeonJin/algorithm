import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int[][] dp;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1][2];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i <= n; i++)
            tree.add(new ArrayList<>());

        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        dfs(1, 0);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
    static void dfs(int n, int parent) {
        for (int nxt : tree.get(n)) {
            if (nxt!=parent) {
                dfs(nxt, n);
                dp[n][0] += Math.max(dp[nxt][0], dp[nxt][1]);
                dp[n][1] += dp[nxt][0];
            }
        }
        dp[n][1] += arr[n];
    }
}