import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr, result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        result = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++)
            result[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(result);
        recur(0, 0);
        System.out.println(sb);
    }

    static void recur(int num, int start){
        if (num == m){
            for (int val : arr)
                sb.append(val).append(" ");
            sb.append("\n");
            return;
        }
        for (int i=start; i<n; i++){
            arr[num] = result[i];
            recur(num+1, i);
        }
    }
}
