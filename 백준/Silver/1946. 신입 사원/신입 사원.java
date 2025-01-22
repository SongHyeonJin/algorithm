import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] ranks = new int[N][2];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                ranks[j][0] = Integer.parseInt(st.nextToken());
                ranks[j][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(ranks, Comparator.comparing(a -> a[0]));
            int cnt = 1;
            int compareInterview = ranks[0][1];
            for (int j = 1; j < ranks.length; j++) {
                if(compareInterview>ranks[j][1]) {
                    compareInterview = ranks[j][1];
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}