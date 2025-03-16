import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] dp;
    static PriorityQueue<Shark> pq = new PriorityQueue<>();
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};
    static class Shark implements Comparable<Shark> {
        int y, x, dis;
        public Shark(int y, int x, int dis) {
            this.y = y;
            this.x = x;
            this.dis = dis;
        }
        @Override
        public int compareTo(Shark o) {
            if (this.dis != o.dis) return Integer.compare(this.dis, o.dis);
            else {
                if(this.y == o.y) return Integer.compare(this.x, o.x);
                else return Integer.compare(this.y, o.y);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n  = Integer.parseInt(br.readLine());
        dp = new int[n][n];
        Queue<Shark> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
                if (dp[i][j]==9) {
                    dp[i][j] = 0;
                    q.offer(new Shark(i, j, 0));
                }
            }
        }

        bfs(q, 2);
        int move = 0, cnt = 0, sharkSize = 2;
        while (!pq.isEmpty()) {
            Shark cur = pq.poll();
            dp[cur.y][cur.x] = 0;
            cnt++;
            if (cnt == sharkSize) {
                cnt = 0;
                sharkSize++;
            }
            move += cur.dis;
            q = new LinkedList<>();
            q.offer(new Shark(cur.y, cur.x, 0));
            bfs(q, sharkSize);
        }
        System.out.println(move);
    }
    static void bfs(Queue<Shark> q, int sharkSize) {
        pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][n];
        while (!q.isEmpty()) {
            Shark cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || dp[ny][nx] > sharkSize || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                q.offer(new Shark(ny, nx, cur.dis + 1));
                if (dp[ny][nx] != 0 && dp[ny][nx] < sharkSize) {
                    pq.offer(new Shark(ny, nx, cur.dis + 1));
                }
            }
        }
    }
}