import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, min = Integer.MAX_VALUE;
    static int[][] board;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(min);
    }
    static void dfs(int idx, int depth) {
        if (depth==n/2) {
            int startTeam=0, linkTeam=0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i==j) continue;
                    if (visited[i] && visited[j]) startTeam += board[i][j];
                    if (!visited[i] && !visited[j]) linkTeam += board[i][j];
                }
            }
            int val = Math.abs(startTeam-linkTeam);
            min = Math.min(min, val);
            return;
        }
        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }
    }
}