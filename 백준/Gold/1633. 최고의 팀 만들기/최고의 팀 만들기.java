import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] white, black;
    static int[][][] dp;
    static int index;
    static String line;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        white = new int[1001];
        black = new int[1001];
        index = 0;
        while ((line = br.readLine())!=null && !line.isEmpty()){
            StringTokenizer st = new StringTokenizer(line);
            white[index] = Integer.parseInt(st.nextToken());
            black[index] = Integer.parseInt(st.nextToken());
            index++;
        }
        dp = new int[1001][16][16];
        System.out.println(dfs(0, 0 ,0, index));
    }
    static int dfs(int index, int wIndex, int bIndex, int total) {
        if (wIndex == 15 && bIndex == 15) return 0;
        if (index == total) return 0;

        if (dp[index][wIndex][bIndex] != 0) return dp[index][wIndex][bIndex];
        int best = dfs(index + 1, wIndex, bIndex, total);
        if (wIndex < 15) best = Math.max(best, dfs(index + 1, wIndex + 1, bIndex, total) + white[index]);
        if (bIndex < 15) best = Math.max(best, dfs(index + 1, wIndex, bIndex + 1, total) + black[index]);
        dp[index][wIndex][bIndex] = best;
        return dp[index][wIndex][bIndex];
    }
}