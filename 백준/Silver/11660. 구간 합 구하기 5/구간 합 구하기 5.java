import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];

        for (int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++){
                graph[i][j] = graph[i][j-1] + graph[i-1][j] - graph[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            answer = graph[x2][y2] - graph[x1-1][y2] - graph[x2][y1-1]  + graph[x1-1][y1-1];
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}