import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Queue<Integer> trucks = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trucks.offer(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < W; i++) {
            bridge.offer(0);
        }

        int time = 0;
        int weightOnBridge = 0;
        while (!bridge.isEmpty()) {
            time++;
            weightOnBridge -= bridge.poll();

            if (trucks.isEmpty()) {
                continue;
            }

            if (trucks.peek() + weightOnBridge <= L) {
                int cur = trucks.poll();
                weightOnBridge += cur;
                bridge.offer(cur);
            } else {
                bridge.offer(0);
            }
        }

        System.out.println(time);
    }
}