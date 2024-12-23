import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, h, count, min = Integer.MAX_VALUE;
    static int[] arr;
    static int[] obstacle;
    static int[] prefix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h];
        prefix = new int[h+1];
        obstacle = new int[n];

        for (int i = 0; i < n; i++) {
            obstacle[i] = Integer.parseInt(br.readLine());
            if (i%2==0) {
                arr[0] ++;
                arr[obstacle[i]]--;
            }
            else {
                arr[h-obstacle[i]]++;
            }
        }
        for (int i = 0; i < h; i++)
            prefix[i+1] = arr[i]+prefix[i];

        for (int i = 1; i <= h; i++) {
            if (min > prefix[i]) {
                min = Math.min(min, prefix[i]);
                count = 1;
            }
            else if (min == prefix[i]) count++;
        }
        System.out.println(min+" "+count);
    }
}
