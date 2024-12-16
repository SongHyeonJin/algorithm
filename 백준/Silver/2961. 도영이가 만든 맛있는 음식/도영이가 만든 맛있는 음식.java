import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, answer = Integer.MAX_VALUE;
    static int[][] ingre;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        ingre = new int[n][2];
        visited = new boolean[n];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            ingre[i][0] = Integer.parseInt(st.nextToken());
            ingre[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 1, 0, 0);
        System.out.println(answer);
    }
    static void dfs(int idx, int sour, int bitter, int use){
        if (idx == n) {
            if (use==0) return;
            answer = Math.min(answer, Math.abs(sour - bitter));
            return;
        }
        visited[idx] = true;
        dfs(idx+1, sour * ingre[idx][0], bitter + ingre[idx][1], use+1);
        visited[idx] = false;
        dfs(idx+1, sour, bitter, use);
    }
}