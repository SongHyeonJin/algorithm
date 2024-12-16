import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, answer = Integer.MIN_VALUE;
    static int[][] interview;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        interview = new int[n][2];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            interview[i][0] = Integer.parseInt(st.nextToken());
            interview[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(answer);
    }
    static void dfs(int idx, int price){
        if (idx == n){
            answer = Math.max(answer, price);
            return;
        }
        if (idx > n-1) return;
        visited[idx] = true;
        dfs(idx+ interview[idx][0], price+ interview[idx][1]);
        visited[idx] = false;
        dfs(idx+1, price);
    }
}