import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static class Loc {
        int y, x, cnt;
        boolean destroy;

        public Loc(int y, int x, int cnt, boolean destroy) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.destroy = destroy;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int y = 0; y < N; y++) {
            String[] nums = br.readLine().split("");
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(nums[x]);
            }
        }
        answer = bfs(0, 0);
        System.out.println(answer);
    }
    static int bfs(int y, int x) {
        Queue<Loc> q = new LinkedList<>();
        visited[y][x][0] = true;
        q.offer(new Loc(y, x, 1, false));

        while (!q.isEmpty()) {
            Loc cur = q.poll();

            if (cur.y==N-1 && cur.x==M-1) {
                return cur.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(ny<0 || nx<0 || ny>=N || nx>=M) continue;

                int nxtCnt = cur.cnt + 1;

                if (map[ny][nx]==0) {
                    if(!cur.destroy && !visited[ny][nx][0]) {
                        q.add(new Loc(ny, nx, nxtCnt, false));
                        visited[ny][nx][0] = true;
                    } else if (cur.destroy && !visited[ny][nx][1]) {
                        q.add(new Loc(ny, nx, nxtCnt, true));
                        visited[ny][nx][1] = true;
                    }
                } else if (map[ny][nx]==1) {
                    if (!cur.destroy && !visited[ny][nx][1]) {
                        q.add(new Loc(ny, nx, nxtCnt, true));
                        visited[ny][nx][1] = true;
                    }
                }
            }
        }
        return -1;
    }
}
