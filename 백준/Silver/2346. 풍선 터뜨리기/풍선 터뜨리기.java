import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Deque;

public class Main {
    static class Balloon {
        int idx, num;
        public Balloon(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Deque<Balloon> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            deque.offerLast(new Balloon(i, num));
        }

        Balloon cur = deque.pollFirst();
        sb.append(cur.idx).append(" ");
        int move = cur.num;
        while (!deque.isEmpty()) {
            if (move > 0) {
                for (int i = 1; i < move; i++) {
                    deque.offerLast(deque.pollFirst());
                }
                Balloon nxt = deque.pollFirst();
                move = nxt.num;
                sb.append(nxt.idx).append(" ");
            } else {
                for (int i = 1; i < -move; i++) {
                    deque.offerFirst(deque.pollLast());
                }
                Balloon nxt = deque.pollLast();
                move = nxt.num;
                sb.append(nxt.idx).append(" ");
            }
        }
        System.out.println(sb);
    }
}