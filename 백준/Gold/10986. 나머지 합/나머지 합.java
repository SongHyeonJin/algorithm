import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] sumArr = new long[N + 1];
        long[] remainArr = new long[M];
        long cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            sumArr[i] = Integer.parseInt(st.nextToken()) + sumArr[i - 1];
            int remain = (int) (sumArr[i] % M);

            if (remain == 0) cnt++;
            remainArr[remain]++;
        }

        for (int i = 0; i < M; i++) {
            if (remainArr[i] > 1) cnt += (remainArr[i] * (remainArr[i] - 1) / 2);
        }

        System.out.println(cnt);
    }
}