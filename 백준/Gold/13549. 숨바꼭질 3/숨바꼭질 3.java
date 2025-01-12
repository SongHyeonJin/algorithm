import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, min = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        dijkstra(N);
        System.out.println(min);
    }
    static void dijkstra(int start) {
        PriorityQueue<Time> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.time - o2.time;
        });
        pq.offer(new Time(start, 0));
        while (!pq.isEmpty()) {
            Time now = pq.poll();
            visited[now.x] = true;
            if (now.x==K) min = Math.min(min, now.time);
            if (now.x*2 <= 100000 && !visited[now.x*2])
                pq.offer(new Time(now.x*2, now.time));
            if (now.x+1<=100000 && !visited[now.x+1])
                pq.offer(new Time(now.x+1, now.time+1));
            if (now.x-1>=0 && !visited[now.x-1])
                pq.offer(new Time(now.x-1, now.time+1));
        }
    }
}

class Time {
    int x, time;

    public Time(int x, int time) {
        this.x = x;
        this.time = time;
    }
}
