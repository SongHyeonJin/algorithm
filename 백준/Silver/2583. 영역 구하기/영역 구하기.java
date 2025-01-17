import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int Y, X, K, size;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static ArrayList<Integer> answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[Y][X];
        visited = new boolean[Y][X];
        answer = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++)
                for (int x = x1; x < x2; x++) {
                    visited[y][x] = true;
                    map[y][x] = 1;
                }
        }

        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (!visited[y][x]) {
                    size = 1;
                    dfs(y, x);
                    answer.add(size);
                }
            }
        }
        Collections.sort(answer);
        sb.append(answer.size()).append("\n");
        for (int a : answer)
            sb.append(a).append(" ");
        System.out.println(sb);
    }
    static void dfs(int y, int x){
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (0<=ny && ny<Y && 0<=nx && nx<X && !visited[ny][nx]) {
                size++;
                dfs(ny, nx);
            }
        }
    }
}
