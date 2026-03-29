import java.io.*;
import java.util.*;

public class Main {
    static int vertex, edge, startVertex, count = 1;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        startVertex = Integer.parseInt(st.nextToken());

        result  = new int[vertex + 1];
        visited = new boolean[vertex + 1];

        for (int i = 0 ; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());
            
            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }

        bfs(startVertex);

        for (int i = 1 ; i <= vertex ; i++) {
            sb.append(result[i]).append("\n");
        }
        
        System.out.println(sb.toString());
    }

    private static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<Integer>();
        result[vertex]  = count++;
        visited[vertex] = true;
        queue.add(vertex);
        
        while (!queue.isEmpty()) {
            int point = queue.poll();
            
            Collections.sort(graph.get(point), Collections.reverseOrder());
            
            for (int next : graph.get(point)) {
                if (!visited[next]) {
                    visited[next] = true;
                    result[next]  = count++;
                    queue.add(next);
                }
            }
        }
    }
}