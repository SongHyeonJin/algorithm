import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[n+1];

        check[0] = check[1] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(check[i]) continue;
            for (int j = i*i; j <= n; j+=i) {
                check[j] = true;
            }
        }

        for (int i = m; i <= n; i++) {
            if (!check[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}