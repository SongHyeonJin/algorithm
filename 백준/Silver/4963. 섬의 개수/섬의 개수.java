import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int Y, X, cnt;
    static int[][] land;
    static int[][] visited;
    static int[] dy = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dx = {0, 1, 0, -1, -1, 1, 1, -1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            if (X==0 && Y==0) break;

            land = new int[Y][X];
            visited = new int[Y][X];
            cnt = 0;

            for (int y = 0; y < Y; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < X; x++) {
                    land[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            for (int y = 0; y < Y; y++) {
                for (int x = 0; x < X; x++) {
                    if (visited[y][x]!=1 && land[y][x]==1) {
                        dfs(y, x);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int y, int x) {
        visited[y][x] = 1;
        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (0<=ny && ny<Y && 0<=nx && nx<X) {
                if (land[ny][nx]==1 && visited[ny][nx]!=1) dfs(ny, nx);
            }
        }
    }
}
