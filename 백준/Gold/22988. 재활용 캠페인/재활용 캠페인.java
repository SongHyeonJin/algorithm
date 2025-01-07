import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        long[] arr = new long[n];
        int count = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int remain = 0;
        int s=0, e=n-1;
        while (s<=e){
            if (arr[e] >= x) {
                count++;
                e--;
                continue;
            }

            if (s==e){
                remain++;
                break;
            }

            if (arr[s] + arr[e] >= x/2.0){
                count++;
                e--;
                s++;
            } else {
                remain++;
                s++;
            }
        }
        System.out.println(count+(remain/3));
    }
}
