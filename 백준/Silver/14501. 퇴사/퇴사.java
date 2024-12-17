import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, answer = Integer.MIN_VALUE;
    static int[][] interview;
    static int[] dp;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        interview = new int[n][2];
        dp = new int[n+1];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            interview[i][0] = Integer.parseInt(st.nextToken());
            interview[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(answer);
    }
    static int dfs(int idx, int price){
        if (idx == n){
            answer = Math.max(answer, price);
            return 0;
        }
        if (idx > n-1) return 0;
        visited[idx] = true;
        dp[idx] = Math.max(dfs(idx+ interview[idx][0], price+ interview[idx][1]),
                dfs(idx+1, price));
        visited[idx] = false;
        return dp[idx];
    }
}