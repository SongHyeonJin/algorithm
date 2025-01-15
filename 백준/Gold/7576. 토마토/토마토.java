import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int X, Y, min;
    static int[][] box;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Queue<Tomato> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        box = new int[Y][X];

        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < X; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j]==1) q.offer(new Tomato(i, j, 0));
            }
        }
        min = bfs();
        System.out.println(min);
    }
    static int bfs() {
        int day = 0;
        while (!q.isEmpty()) {
            Tomato cur = q.poll();
            day = cur.day;

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (0<=ny && ny<Y && 0<=nx && nx<X) {
                    if (box[ny][nx] == 0) {
                        box[ny][nx] = 1;
                        q.offer(new Tomato(ny, nx, day+1));
                    }
                }
            }
        }
        if (checkTomato()) return day;
        else return -1;
    }
    static boolean checkTomato(){
        for (int i = 0; i < Y; i++)
            for (int j = 0; j < X; j++)
                if (box[i][j] == 0) return false;
        return true;
    }
    static class Tomato{
        int y, x, day;

        public Tomato(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }
}
