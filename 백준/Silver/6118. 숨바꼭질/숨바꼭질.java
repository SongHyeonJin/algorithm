import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, maxDis;
    static int[] arr;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static class Node {
        int idx, dis;

        public Node(int idx, int dis) {
            this.idx = idx;
            this.dis = dis;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs();

        int minIdx = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i]==maxDis) {
                minIdx = Math.min(minIdx, i);
                cnt++;
            }
        }
        System.out.println(minIdx+" "+maxDis+" "+cnt);
    }
    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));
        visited[1] = true;

        while (!q.isEmpty()) {
            Node cur =  q.poll();

            maxDis = Math.max(maxDis, cur.dis);
            arr[cur.idx] = maxDis;
            for (int i = 0; i < graph.get(cur.idx).size(); i++) {
                int nxtIdx = graph.get(cur.idx).get(i);

                if (!visited[nxtIdx]) {
                    q.offer(new Node(nxtIdx, cur.dis+1));
                    visited[nxtIdx] = true;
                }
            }
        }
    }
}
