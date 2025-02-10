import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr, rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        rank = new int[n+1];
        for (int i = 0; i <= n; i++) arr[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (type==0) union(a, b);
            else {
                if (find(a)==find(b)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a==b) return;

        if (rank[a] < rank[b])
            arr[a] = b;
        else if (rank[b] < rank[a])
            arr[b] = a;
        else {
            arr[a] = b;
            rank[b]++;
        }
    }
    static int find(int num) {
        if (arr[num]==num) return num;
        else {
            arr[num] = find(arr[num]);
            return find(arr[num]);
        }
    }
}
