import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        long N = Long.parseLong(st.nextToken());
        long[] arr = new long[K];

        for (int i = 0; i < K; i++)
            arr[i] = Long.parseLong(br.readLine());
        Arrays.sort(arr);

        long s=1, e=arr[K-1];
        while (s<=e) {
            long mid = (s+e)/2;
            long line = 0;

            for (long lan : arr) {
                line += (lan/mid);
            }
            if (line<N)
                e = mid-1;
            else s = mid+1;
        }
        System.out.println(e);
    }
}
