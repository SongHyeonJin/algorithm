import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k, size, maxSize;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[r-1][c-1] = 1;
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                size=0;
                if (!visited[y][x] && graph[y][x]==1) {
                    dfs(y, x);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        System.out.println(maxSize);
    }
    static void dfs(int y, int x) {
        visited[y][x] = true;
        size++;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (0>ny || ny>=n || 0>nx || nx>=m) continue;

            if (!visited[ny][nx] && graph[ny][nx]==1) dfs(ny, nx);
        }
    }
}
