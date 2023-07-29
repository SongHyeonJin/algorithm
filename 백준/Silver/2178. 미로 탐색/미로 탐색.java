import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] moveX = {0, 0, 1, -1};
    static int[] moveY = {1, -1, 0, 0};
    static class Node {
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                char c = str.charAt(j);
                map[i][j] =  Character.getNumericValue(c);
            }
        }
        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(map[N-1][M-1]);
    }
    static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));

        while (!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<4; i++){
                int nextX = node.x + moveX[i];
                int nextY = node.y + moveY[i];
                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M &&
                        !visited[nextX][nextY] && map[nextX][nextY] != 0) {
                q.add(new Node(nextX, nextY));
                map[nextX][nextY] = map[node.x][node.y] + 1;
                visited[nextX][nextY] = true;
                }
            }
        }
    }
}
