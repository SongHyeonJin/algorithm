import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> noListen = new HashSet<>();
        for (int i = 0; i < N; i++) {
            noListen.add(br.readLine());
        }

        Set<String> dbj = new TreeSet<>();
        for (int i = 0; i < M; i++) {
            String person = br.readLine();
            if (noListen.contains(person)) dbj.add(person);
        }

        sb.append(dbj.size()).append("\n");
        for (String person : dbj) sb.append(person).append("\n");

        System.out.println(sb.toString());
    }
}
