import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int F, S, G, U, D, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        F = Integer.parseInt(str[0]);
        S = Integer.parseInt(str[1]);
        G = Integer.parseInt(str[2]);
        U = Integer.parseInt(str[3]);
        D = Integer.parseInt(str[4]);

        int[] cnt = new int[F+1];
        Arrays.fill(cnt, Integer.MAX_VALUE);
        cnt[S] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now==G) {
                System.out.println(cnt[G]);
                return;
            }

            int up = now + U;
            if (up>=1 && up<=F && cnt[up]>cnt[now]+1) {
                q.offer(up);
                cnt[up] = cnt[now]+1;
            }

            int down = now - D;
            if (down>=1 && down<=F && cnt[down]>cnt[now]+1) {
                q.offer(down);
                cnt[down] = cnt[now]+1;
            }
        }
        System.out.println("use the stairs");
    }
}
