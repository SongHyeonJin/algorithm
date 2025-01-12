import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, X;
    static ArrayList<City>[] graph;
    static ArrayList<City>[] backGraph;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        backGraph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            backGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[start].add(new City(end, time));
            backGraph[end].add(new City(start, time));
        }

        int[] result = dijkstra(graph, X, N);
        int[] backResult = dijkstra(backGraph, X, N);

        int max = 0;
        for (int i = 1; i <= N; i++)
            max = Math.max(max, result[i]+backResult[i]);
        System.out.println(max);
    }
    static int[] dijkstra(ArrayList<City>[] city, int start, int n){
        PriorityQueue<City> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.time - o2.time;
        });

        visited = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new City(start, 0));

        while (!pq.isEmpty()) {
            City now = pq.poll();
            int curRoadNum = now.roadNum;
            if (visited[curRoadNum]) continue;
            visited[curRoadNum] = true;
            for (City nxt : city[curRoadNum]) {
                int nxtRoadNum = nxt.roadNum;
                if (dist[nxtRoadNum]>dist[curRoadNum]+nxt.time) {
                    dist[nxtRoadNum] = dist[curRoadNum]+nxt.time;
                    pq.add(new City(nxtRoadNum, dist[nxtRoadNum]));
                }
            }
        }
        return dist;
    }
}
class City {
    int roadNum, time;

    public City(int roadNum, int time) {
        this.roadNum = roadNum;
        this.time = time;
    }
}