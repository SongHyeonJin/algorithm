import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, answer;
    static int[][] graph;
    static int[][] dp;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dp[i][j] = -1;

        for (int i = 0; i < n; i++) {
             st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }
        answer = dfs(0, 0);
        System.out.println(answer);
    }
    static int dfs(int y, int x){
        if (y == n -1 && x == m -1) return 1;
        if (dp[y][x] != -1) return dp[y][x];
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && ny < n && nx >= 0 && nx < m)
                if (graph[y][x] > graph[ny][nx]) {
                    count += dfs(ny, nx);
                }
        }
        dp[y][x] = count;
        return dp[y][x];
    }
}
