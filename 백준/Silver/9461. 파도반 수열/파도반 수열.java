import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        long[] pn = new long[101];
        pn[1] = pn[2] = pn[3] = 1;
        for (int i = 4; i < 101; i++) {
            pn[i] = pn[i-2] + pn[i-3];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(pn[n]).append("\n");
        }
        System.out.println(sb);
    }
}
