import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int vertex, weight;
    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        int sum = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.vertex]) continue;
            visited[now.vertex] = true;
            sum += now.weight;
            count++;

            if (count == V) break;

            for (Node next : graph.get(now.vertex)) {
                if (!visited[next.vertex]) {
                    pq.offer(next);
                }
            }
        }
        System.out.println(sum);
    }
}