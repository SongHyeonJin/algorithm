import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String blank = " ".repeat(n-1-i);
            String star = "*".repeat(2*i+1);
            sb.append(blank + star).append("\n");
        }

        int idx = 1;
        for (int i = n; i < 2*n-1; i++) {
            String blank = " ".repeat(i-n+1);
            String star = "*".repeat((2*n-1)-2*idx++);
            sb.append(blank + star).append("\n");
        }
        System.out.println(sb);
    }
}
