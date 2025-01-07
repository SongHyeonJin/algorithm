import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int num = Integer.parseInt(br.readLine());

        int s = 0, e = n-1;
        while (s < e){
            if (arr[s]+arr[e] == num) {
                e--;
                count++;
            }
            if (arr[s]+arr[e] > num) e--;
            if (arr[s]+arr[e] < num) s++;
        }
        System.out.println(count);
    }
}