import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int Y, X, maxSafe = Integer.MIN_VALUE;
    static int[] dy = {1, 0, -1 ,0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static int[][] virusMap;
    static Queue<Virus> q = new LinkedList<>();
    static class Virus{
        int y, x;
        public Virus(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new int[Y][X];

        for (int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < X; x++)
                map[y][x] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(maxSafe);
    }
    static void dfs(int wall) {
        if (wall==3) {
            bfs();
            return;
        }
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (map[y][x] == 0) {
                    map[y][x] = 1;
                    dfs(wall+1);
                    map[y][x] = 0;
                }
            }
        }
    }
    static int bfs() {
        virusMap = new int[Y][X];
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                virusMap[y][x] = map[y][x];
                if (map[y][x]==2) q.offer(new Virus(y, x));
            }
        }

        while (!q.isEmpty()) {
            Virus v = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = v.y + dy[i];
                int nx = v.x + dx[i];
                if (0<=ny && ny<Y && 0<=nx && nx<X) {
                    if (virusMap[ny][nx] == 0) {
                        virusMap[ny][nx] = 2;
                        q.offer(new Virus(ny, nx));
                    }
                }
            }
        }
        int safeZone = 0;
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (virusMap[y][x] == 0) safeZone++;
            }
        }
        maxSafe = Math.max(safeZone, maxSafe);
        return maxSafe;
    }
}