import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, cnt;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];
        visited = new boolean[n][m];

        for (int y = 0; y < n; y++) {
            String str = br.readLine();
            for (int x = 0; x < str.length(); x++) {
                graph[y][x] = str.charAt(x);
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (!visited[y][x] && graph[y][x]=='I') {
                    dfs(y, x);
                }
            }
        }
        System.out.println(cnt==0 ? "TT" : cnt);
    }
    static void dfs(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (0>ny || ny>=n || 0>nx || nx>=m) continue;

            if (!visited[ny][nx] && graph[ny][nx]!='X') {
                if (graph[ny][nx]=='P') cnt++;
                dfs(ny, nx);
            }
        }
    }
}
