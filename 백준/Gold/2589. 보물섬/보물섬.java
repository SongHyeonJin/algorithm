import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int Y, X;
    static char[][] graph;
    static int[][] visited;
    static int[][] dist;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new char[Y][X];

        for (int i = 0; i < Y; i++)
            graph[i] = br.readLine().toCharArray();

        int max = 0;

        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (graph[y][x] == 'L') {
                    visited = new int[Y][X];
                    dist = new int[Y][X];
                    visited[y][x] = 1;

                    max = bfs(y, x, max);
                }
            }
        }
        System.out.println(max);
    }
    private static int bfs(int y, int x, int max) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        while (!queue.isEmpty()){
            int[] tmp = queue.poll();
            int ey = tmp[0];
            int ex = tmp[1];
            for (int i = 0; i < 4; i++) {
                int ny = ey + dy[i];
                int nx = ex + dx[i];
                if (0<=ny && ny<Y && 0<=nx && nx<X){
                    if (graph[ny][nx] == 'L'){
                        if (visited[ny][nx] == 0) {
                            visited[ny][nx] = 1;
                            dist[ny][nx] = dist[ey][ex] + 1;
                            max = Math.max(max, dist[ny][nx]);
                            queue.add(new int[]{ny, nx});
                        }
                    }
                }
            }
        }
        return max;
    }
}
