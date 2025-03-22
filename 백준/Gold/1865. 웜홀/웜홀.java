import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    static Edge[] edge;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edge = new Edge[2*m + w];
            int idx = 0;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                edge[idx++] = new Edge(from, to, weight);
                edge[idx++] = new Edge(to, from, weight);
            }

            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                edge[idx++] = new Edge(from, to, -weight);
            }

            dist = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dist[i] = 0;
            }
            sb.append(bellmanFord(n) ? "YES" : "NO").append("\n");
        }
        System.out.println(sb.toString());
    }
    static boolean bellmanFord(int n) {
        boolean cycle = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < edge.length; j++) {
                Edge cur = edge[j];
                if (dist[cur.to] > dist[cur.from] + cur.weight) {
                    dist[cur.to] = dist[cur.from] + cur.weight;
                    if (i == n) {
                        cycle = true;
                    }
                }
            }
        }
        return cycle;
    }
}