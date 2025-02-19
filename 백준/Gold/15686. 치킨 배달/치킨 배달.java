import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m, minDis=Integer.MAX_VALUE;
    static ArrayList<Node> house = new ArrayList<>();
    static ArrayList<Node> chicken = new ArrayList<>();
    static int[][] city;
    static boolean[] visited;
    static class Node {
        int y, x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        city = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j]==1) house.add(new Node(i, j));
                if (city[i][j]==2) chicken.add(new Node(i, j));
            }
        }

        visited = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(minDis);
    }
    static void dfs(int count, int idx) {
        if (count==m) {
            int total = 0;
            for (int i = 0; i < house.size(); i++) {
                int sum = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {
                        int dis = Math.abs(house.get(i).y-chicken.get(j).y) + Math.abs(house.get(i).x-chicken.get(j).x);
                        sum = Math.min(sum, dis);
                    }
                }
                total += sum;
            }
            minDis = Math.min(minDis, total);
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(count+1, i+1);
                visited[i] = false;
            }
        }
    }
}