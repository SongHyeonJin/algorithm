import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] prefix = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        prefix[0] = arr[0];
        int max = prefix[0];
        for (int i=1; i<n; i++) {
            prefix[i] = Math.max(prefix[i - 1] + arr[i], arr[i]);
            max = Math.max(max, prefix[i]);
        }

        System.out.println(max);
    }
}