import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, start, end, result = -1;
    static boolean[] visited;
    static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        dfs(start, 0);
        System.out.println(result);
    }
    static void dfs(int node, int count){
        visited[node] = true;
        for(int x : graph.get(node)){
            if(!visited[x]){
                if(x == end){
                    result = count + 1;
                    return;
                }
                dfs(x, count + 1);
            }
        }
    }
}