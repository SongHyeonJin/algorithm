import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
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
            arr[num] = i+1;
            recur(num+1, i);
        }
    }
}
