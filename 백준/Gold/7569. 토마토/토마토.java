import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int X, Y, H, count;
    static int[][][] box;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static class Point {
        int h, y, x;
        public Point(int h, int y, int x) {
            this.h = h;
            this.y = y;
            this.x = x;
        }
    }
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][Y][X];

        for (int h = 0; h < H; h++) {
            for (int y = 0; y < Y; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < X; x++) {
                    box[h][y][x] = Integer.parseInt(st.nextToken());
                    if (box[h][y][x]==1) q.add(new Point(h, y, x));
                }
            }
        }

        bfs();
        for (int h = 0; h < H; h++) {
            for (int y = 0; y < Y; y++) {
                for (int x = 0; x < X; x++) {
                    if (box[h][y][x]==0) {
                        System.out.println(-1);
                        return;
                    }
                    count = Math.max(count, box[h][y][x]);
                }
            }
        }
        System.out.println(count==1 ? 0 : count-1);
    }
    static void bfs() {
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            int h = tmp.h;
            int y = tmp.y;
            int x = tmp.x;

            for (int i = 0; i < 6; i++) {
                int nh = h + dh[i];
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (0>nh || nh>=H ||0>ny || ny>=Y || 0>nx || nx>=X) continue;

                if (box[nh][ny][nx]==0) {
                    q.add(new Point(nh, ny, nx));
                    box[nh][ny][nx] = box[h][y][x]+1;
                }
            }
        }
    }
}
