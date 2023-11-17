import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n, m, start,count;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] check;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        check = new int[n+1];

        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<>());


        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i=1; i<graph.size(); i++)
            Collections.sort(graph.get(i));

        count = 1;
        dfs(start);

        for(int i=1; i<check.length; i++){
            sb.append(check[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int start){
        check[start] = count;

        for(int i=0; i<graph.get(start).size(); i++){
            int newStart = graph.get(start).get(i);
            if(check[newStart] == 0){
                count++;
                dfs(newStart);
            }
        }
    }
}
