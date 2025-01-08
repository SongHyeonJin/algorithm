import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, cnt;
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int com = Integer.parseInt(st.nextToken());
            int ssang = Integer.parseInt(st.nextToken());
            graph[com][ssang] = graph[ssang][com] = 1;
        }
        bfs(1);
        System.out.println(cnt);
    }
    static void bfs(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){
            int tmp = queue.poll();
            visited[tmp] = true;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && graph[tmp][i] == 1){
                    queue.add(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
    }
}