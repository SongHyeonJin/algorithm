import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, t;
    static int map[][];
    static boolean visited[][][];

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    static class point {
        int x;
        int y;
        int time;
        boolean gram;

        public point(int x, int y, int time, boolean gram) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.gram = gram;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = bfs(0, 0);
        if (ans == -1) System.out.println("Fail");
        else System.out.println(ans);
    }

    public static int bfs(int x, int y) {
        Queue<point> queue = new LinkedList<>();
        queue.add(new point(x, y, 0, false));
        visited[x][y][0] = true;

        while (!queue.isEmpty()) {
            point point = queue.poll();
            if (point.time > t) break;
            if (point.x == n - 1 && point.y == m - 1) return point.time;
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dr[i];
                int ny = point.y + dc[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!point.gram) {
                        if (!visited[nx][ny][0] && map[nx][ny] == 0) {
                            queue.add(new point(nx, ny, point.time + 1, point.gram));
                        } else if (!visited[nx][ny][0] && map[nx][ny] == 2) {
                            queue.add(new point(nx, ny, point.time + 1, true));
                        }
                        visited[nx][ny][0] = true;
                    } else {
                        if (!visited[nx][ny][1]) {
                            queue.offer(new point(nx, ny, point.time + 1, point.gram));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
