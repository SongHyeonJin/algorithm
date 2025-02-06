import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, totalDepth;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++)
            tree.add(new ArrayList<>());

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        search(0, 1, 0);
        System.out.println(totalDepth%2==1 ? "Yes" : "No");
    }
    static void search(int depth, int cur, int parent) {
        boolean check = false;
        for (int nxt : tree.get(cur)) {
            if (parent!=nxt) {
                check = true;
                search(depth+1, nxt, cur);
            }
        }
        if (!check) totalDepth += depth;
    }
}