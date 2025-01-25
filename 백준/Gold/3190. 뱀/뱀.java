import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static List<int[]> snake = new ArrayList<>();
    static int n, k, l;
    static HashMap<Integer, String> hashMap = new HashMap<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y-1][x-1] = 1;
        }

        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            hashMap.put(second, direction);
        }

        int y=0, x=0;
        int d=0;
        int time=0;
        snake.add(new int[]{y, x});
        while (true) {
            time++;

            int ny = y+dy[d];
            int nx = x+dx[d];

            if (isFinish(ny, nx)) break;

            if (map[ny][nx]==1) {
                map[ny][nx]=0;
                snake.add(new int[]{ny, nx});
            } else {
                snake.add(new int[]{ny, nx});
                snake.remove(0);
            }

            if (hashMap.containsKey(time)) {
                if (hashMap.get(time).equals("D")) {
                    d += 1;
                    if (d == 4) d = 0;
                }
                else {
                    d -= 1;
                    if (d == -1) d=3;
                }
            }
            y = ny;
            x = nx;
        }
        System.out.println(time);
    }
    static boolean isFinish(int ny, int nx) {
        if (ny<0 || ny>=n || nx<0 ||nx>=n) return true;

        for (int[] t : snake) {
            if (ny==t[0] && nx==t[1]) return true;
        }
        return false;
    }
}