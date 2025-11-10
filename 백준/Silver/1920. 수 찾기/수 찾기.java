import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int answer = 0, start = 0, end = N - 1;
            int num = Integer.parseInt(st.nextToken());
            while (start <= end) {
                int mid = (start + end) / 2;
                if (A[mid] == num) {
                    answer = 1;
                    break;
                }

                if (A[mid] > num) end = mid - 1;
                else start = mid + 1;
            }
            System.out.println(answer);
        }
    }
}
