import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, count, max;
    static int[][] graph;
    static int[][] dp;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count = dfs(i, j);
                if (max < count) max = count;
            }
        }
        System.out.println(max);
    }
    static int dfs(int x, int y){
        if (dp[x][y] != 0) return dp[x][y];

        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            for (int j = 0; j < n; j++) {
                if (nx >= 0 && nx < n && ny >= 0 && ny < n){
                    if (graph[nx][ny] > graph[x][y]) {
                        dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
                    }
                }
            }
        }
        return dp[x][y];
    }
}
