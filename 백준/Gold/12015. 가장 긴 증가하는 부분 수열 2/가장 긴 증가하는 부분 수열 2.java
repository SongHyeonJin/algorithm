import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int length = 1;
        for (int i = 1; i < N; i++) {
            int key = arr[i];

            if (dp[length-1] < key) {
                dp[length++] = key;
            }
            else {
                int left = 0;
                int right = length - 1;
                while (left < right) {
                    int mid = (left+right) / 2;
                    if(dp[mid] < key) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                dp[left] = key;
            }
        }
        System.out.println(length);
    }
}
