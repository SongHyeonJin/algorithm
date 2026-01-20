import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T --> 0){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long totalMoney = 0, maxPrice = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (maxPrice < arr[j]) {
                    maxPrice = arr[j];
                } else {
                    totalMoney += (maxPrice - arr[j]);
                }
            }

            sb.append(totalMoney).append("\n");
        }

        System.out.println(sb.toString());
    }
}