import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i=0; i<k; i++)
            max += arr[i];
        int sum = max;
        for (int i=k; i<n; i++){
            sum = sum - arr[i-k] + arr[i];
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}