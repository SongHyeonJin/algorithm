import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new char[n][n];
        visited =  new boolean[n][n];

        for (int y = 0; y < n; y++) {
            String str = br.readLine();
            for (int x = 0; x < n; x++) {
                graph[y][x] = str.charAt(x);
            }
        }

        int cnt=0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (!visited[y][x]) {
                    dfs(y, x);
                    cnt++;
                }
            }
        }
        sb.append(cnt).append(" ");

        cnt=0;
        visited = new boolean[n][n];
        for (int y = 0; y < n; y++)
            for (int x = 0; x < n; x++)
                if (graph[y][x]=='G') graph[y][x] = 'R';

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (!visited[y][x]) {
                    dfs(y, x);
                    cnt++;
                }
            }
        }
        sb.append(cnt);
        System.out.println(sb);
    }
    static void dfs(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (nx<0 || nx>=n || ny<0 || ny>=n) continue;
            
            if (!visited[ny][nx] && graph[ny][nx]==graph[y][x])
                dfs(ny, nx);
        }
    }
}