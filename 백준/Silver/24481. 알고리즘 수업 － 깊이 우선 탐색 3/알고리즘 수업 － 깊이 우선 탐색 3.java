import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n, m, start;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        visited = new int[n+1];

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i=1; i<graph.size(); i++)
            Collections.sort(graph.get(i));

        Arrays.fill(visited, -1);
        visited[start] = 0;
        dfs(start, 0);

        for(int i=1; i<visited.length; i++)
            System.out.println(visited[i]);
    }
    static void dfs(int start, int depth){
        visited[start] = depth;
        for(int i=0; i<graph.get(start).size(); i++){
            int newStart = graph.get(start).get(i);
            if(visited[newStart] == -1) 
                dfs(newStart, depth+1);
        }
    }
}