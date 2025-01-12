import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, E, INF = 200_000_100;
    static List<Edge>[] graph;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int distA = 0;
        int distB = 0;

        distA += dijkstra(1, v1);
        distA += dijkstra(v1, v2);
        distA += dijkstra(v2, N);

        distB += dijkstra(1, v2);
        distB += dijkstra(v2, v1);
        distB += dijkstra(v1, N);

        int answer = (distA>=INF && distB>=INF) ? -1 : Math.min(distA, distB);
        System.out.println(answer);
    }
    static int dijkstra(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.len - o2.len;
        });
        dist = new int[N+1];
        for (int i = 0; i <= N; i++) dist[i] = INF;
        pq.add(new Edge(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()){
            Edge curEdge = pq.poll();
            int nowNum = curEdge.num;
            int len = curEdge.len;

            if (dist[nowNum]<len) continue;
            for (Edge nxt : graph[nowNum]) {
                int nxtNum = nxt.num;
                int nxtLen = nxt.len;

                int cost = len + nxtLen;
                if (cost<dist[nxtNum]) {
                    dist[nxtNum] = cost;
                    pq.add(new Edge(nxtNum, cost));
                }
            }
        }
        return dist[end];
    }
}
class Edge {
    int num, len;

    public Edge(int num, int len) {
        this.num = num;
        this.len = len;
    }
}
