import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] parent;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);
        for (int i = 2; i <= n; i++)
            System.out.println(parent[i]);
    }
    static void dfs(int idx) {
        visited[idx] = true;
        for (int nxt : graph[idx]) {
            if (visited[nxt]) continue;
            parent[nxt] = idx;
            dfs(nxt);
        }
    }
}