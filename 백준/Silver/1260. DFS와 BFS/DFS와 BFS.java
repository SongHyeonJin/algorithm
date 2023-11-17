import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, v;
    static int[][] map;
    static boolean[] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = 1;
        }

        dfs(v);
        sb.append("\n");

        visited = new boolean[n+1];
        bfs(v);
        System.out.println(sb.toString());
    }
    static void dfs(int start){
        visited[start] = true;
        sb.append(start+" ");
        for(int i=0; i<=n; i++){
            if(map[start][i] == 1 && !visited[i])
                dfs(i);
        }
    }
    static void bfs(int start){
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()){
            start = q.poll();
            sb.append(start+" ");
            for(int i=0; i<=n; i++)
                if(map[start][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
        }
    }
}