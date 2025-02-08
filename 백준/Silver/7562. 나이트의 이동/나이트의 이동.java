import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int t, n, x1, x2, y1, y2;
    static int[][] dp;
    static boolean[][] visited;
    static int[] dy = {2, 1, -1 , -2, -2 ,-1, 1 ,2};
    static int[] dx = {1 , 2, 2, 1, -1, -2, -2, -1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            dp = new int[n][n];
            visited = new boolean[n][n];
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            bfs();

            sb.append(dp[x2][y2]).append("\n");
        }
        System.out.println(sb);
    }
    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x1, y1});
        visited[x1][y1] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0>nx || nx>=n || 0>ny || ny>=n) continue;

                if (!visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    dp[nx][ny] = dp[x][y] + 1;
                    visited[nx][ny] = true;
                }
            }
        }
    }
}