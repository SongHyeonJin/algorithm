import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
     static int n, max=0;
     static ArrayList<Node>[] graph;
     static boolean[] visited;
     static class Node {
         int link, value;
         public Node(int link, int value) {
             this.link = link;
             this.value = value;
         }
     }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, value));
            graph[to].add(new Node(from, value));
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            visited[i] = true;
            dfs(i, 0);
        }
        System.out.println(max);
    }
    static void dfs(int num, int value) {
        for (Node node : graph[num]) {
            if (!visited[node.link]) {
                visited[node.link] = true;
                dfs(node.link, value+node.value);
            }
        }
        max = Math.max(max, value);
    }
}
