import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            if (order==1 || order==2) {
                int num = Integer.parseInt(st.nextToken());
                if (order==1) deque.offerFirst(num);
                else deque.offerLast(num);
            }

            if (order==3) {
                sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
            }

            if (order==4) {
                sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
            }

            if (order==5) {
                sb.append(deque.size()).append("\n");
            }

            if (order==6) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            }

            if (order==7) {
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
            }

            if (order==8) {
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
