import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Coordinate> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.y==o2.y) return o1.x - o2.x;
            return o1.y - o2.y;
        });

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.offer(new Coordinate(x, y));
        }
        while (!pq.isEmpty()) {
            Coordinate cur = pq.poll();
            System.out.println(cur.x+" "+cur.y);
        }
    }
}