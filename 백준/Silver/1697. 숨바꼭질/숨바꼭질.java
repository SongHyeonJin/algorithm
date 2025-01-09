import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            return;
        }

        visited = new boolean[100001];
        visited[n] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        int size = q.size();
        int count = 0;
        while (true) {
            count++;
            size = q.size();
            for (int i = 0; i < size; i++) {
                int tmp = q.poll();
                if (tmp-1 == k || tmp+1 == k || tmp*2 == k){
                    System.out.println(count);
                    return;
                }
                if (tmp-1>=0 && !visited[tmp-1]) {
                    visited[tmp-1] = true;
                    q.add(tmp-1);
                }
                if (tmp+1<=100000 && !visited[tmp+1]) {
                    visited[tmp+1] = true;
                    q.add(tmp+1);
                }
                if (tmp*2<=100000 && !visited[tmp*2]) {
                    visited[tmp*2] = true;
                    q.add(tmp*2);
                }
            }
        }
    }
}
