import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, size;
    static int[][] picture;
    static boolean[][] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        picture = new int[n][m];
        visited = new boolean[n][m];

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                picture[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                size=0;
                if (!visited[y][x] && picture[y][x]==1) {
                    dfs(y, x);
                    answer.add(size);
                }
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        System.out.println(answer.isEmpty() ? 0 : answer.get(answer.size()-1));
    }
    static void dfs(int y, int x) {
        visited[y][x] = true;
        size++;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny<0 || ny>=n || nx<0 || nx>=m) continue;

            if (!visited[ny][nx] && picture[ny][nx]==1)
                dfs(ny, nx);
        }
    }
}
