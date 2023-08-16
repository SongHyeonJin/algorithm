import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K, count;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            visited = new boolean[M][N];

            K = Integer.parseInt(st.nextToken());
            for(int j=0; j<K; j++){
                st = new StringTokenizer(br.readLine());
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                map[p1][p2] = 1;
            }

            for(int x=0; x<M; x++){
                for(int y=0; y<N; y++){
                    if(map[x][y] == 1 && !visited[x][y]){
                        dfs(x, y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }
    static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < M && ny >= 0 && ny < N){
                if(!visited[nx][ny] && map[nx][ny] == 1) dfs(nx, ny);
            }
        }
    }
}
