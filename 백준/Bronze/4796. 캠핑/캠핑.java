import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int idx = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if (L==0 && P==0 && V==0) break;

            int day = 0;
            int div = V/P;
            int rest = Math.min(L, V%P);
            day = div*L + rest;
            sb.append("Case ").append(idx++).append(": ").append(day).append("\n");
        }
        System.out.println(sb);
    }
}
