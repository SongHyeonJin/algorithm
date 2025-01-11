import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Bus>[] graph;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[s].add(new Bus(e, cost));
        }

        st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
        dijkstra(startCity);
        System.out.println(dist[endCity]);
    }
    static void dijkstra(int startCity){
        PriorityQueue<Bus> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });
        dist[startCity] = 0;
        pq.offer(new Bus(startCity, 0));
        while (!pq.isEmpty()) {
            Bus curBus = pq.poll();
            int curEnd = curBus.end;
            if (visited[curEnd] ) continue;
            visited[curEnd] = true;
            for (Bus bus : graph[curEnd]) {
                if (!visited[bus.end] && dist[bus.end] > dist[curEnd]+bus.cost){
                    dist[bus.end] = dist[curEnd]+bus.cost;
                    pq.offer(new Bus(bus.end, dist[bus.end]));
                }
            }
        }
    }
}
class Bus{
    int end, cost;

    public Bus(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}
