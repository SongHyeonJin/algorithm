import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;
        while ((s = br.readLine()) != null && !s.isEmpty()) {
            int n = Integer.parseInt(s);
            String cantor = "-";

            for (int i = 0; i < n; i++) {
                cantor = dfs(cantor);
            }
            sb.append(cantor).append("\n");
        }
        System.out.println(sb);
    }

    static String dfs(String prev) {
        String blank = " ".repeat(prev.length());

        return prev + blank + prev;
    }
}
