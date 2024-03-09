import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        visited = new int[n+1];

        for(int i=0; i<=n; i++)
            list.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i=1; i<=n; i++)
            Collections.sort(list.get(i));

        bfs(r);

        for(int i=1; i<=n; i++)
            System.out.println(visited[i]);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int count = 1;

        q.offer(start);
        visited[start] = count++;

        while (!q.isEmpty()){
            int a = q.poll();
            for(int i=0; i<list.get(a).size(); i++){
                int nextA = list.get(a).get(i);
                if(visited[nextA] != 0) continue;

                q.offer(nextA);
                visited[nextA] = count++;
            }
        }
    }
}