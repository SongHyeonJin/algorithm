import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        long M = Long.parseLong(br.readLine());

        int s=1, e=arr[N-1];
        while (s<=e) {
            int mid = (s+e)/2;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] <= mid) {
                    sum += arr[i];
                } else sum += mid;
            }
            if (sum > M) e = mid-1;
            else s = mid+1;
        }
        System.out.println(e);
    }
}
