import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E, K;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        graph = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++)
            graph[i] = new ArrayList<>();
        for (int j = 0; j < E; j++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }
        dijkstra(K);
        for (int i = 1; i <= V; i++) {
            if (i == K)
                sb.append(0).append("\n");
            else if (dist[i] == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra(int s) {
        dist = new int[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        pq.add(new Node(s, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Node node : graph[cur.end]) {
                int newCost = cur.cost + node.cost;
                int cost = dist[node.end];
                if (cost > newCost) {
                    dist[node.end] = newCost;
                    pq.add(new Node(node.end, newCost));
                }
            }

        }
    }
}

class Node {
    int end, cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}
