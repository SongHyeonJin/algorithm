import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, totalDis;
    static class Node {
        int link, distance;
        public Node(int link, int distance) {
            this.link = link;
            this.distance = distance;
        }
    }
    static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++)
            tree.add(new ArrayList<>());

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            tree.get(a).add(new Node(b, dis));
            tree.get(b).add(new Node(a, dis));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            search(a, b);
            sb.append(totalDis).append("\n");
        }
        System.out.println(sb);
    }
    static void search(int start, int end) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        q.add(new Node(start, 0));
        totalDis = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.link==end) {
                totalDis = cur.distance;
                return;
            }
            for (Node nxt : tree.get(cur.link)) {
                if (!visited[nxt.link]) {
                    visited[nxt.link] = true;
                    q.add(new Node(nxt.link, cur.distance+nxt.distance));
                }
            }
        }
    }
}