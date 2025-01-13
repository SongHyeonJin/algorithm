import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Long.parseLong(st.nextToken());
        Arrays.sort(arr);


        int s=0, e=N-1;
        int l=0, r=0;
        long min = Long.MAX_VALUE;
        while (s<e) {
            if (arr[s]+arr[e] == 0) {
                sb.append(arr[s]).append(" ");
                sb.append(arr[e]);
                System.out.println(sb);
                return;
            }
            if (min > Math.abs(arr[s]+arr[e])) {
                l = s;
                r = e;
                min = Math.abs(arr[s]+arr[e]);
                if (Math.abs(arr[s])>Math.abs(arr[e])) s++;
                else e--;
            } else {
                if (Math.abs(arr[s])>Math.abs(arr[e])) s++;
                else e--;
            }
        }
        sb.append(arr[l]).append(" ");
        sb.append(arr[r]);
        System.out.println(sb);
    }
}
