import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, max, answer=1;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, graph[i][j]);
            }
        }
        for (int h = 1; h <= max; h++) {
            visited = new boolean[n][n];
            int count = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (graph[y][x] > h && !visited[y][x]){
                        count++;
                        dfs(y, x, h);
                    }
                }
            }
            answer = Math.max(count, answer);
        }
        System.out.println(answer);
    }
    static void dfs(int y, int x, int h){
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny>=0 && ny<n && nx>=0 && nx<n && !visited[ny][nx] && graph[ny][nx] > h)
                dfs(ny, nx, h);
        }
    }
}
