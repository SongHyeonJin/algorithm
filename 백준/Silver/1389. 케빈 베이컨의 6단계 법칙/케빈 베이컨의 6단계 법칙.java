import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, count, total;
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;
    static class Bacon {
        int num, value;
        public Bacon(int num, int value){
            this.num = num;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = map[y][x] = 1;
        }
        for (int i=1; i<=N; i++){
            visited = new boolean[N+1];
            bfs(i);
        }
        System.out.println(count);
    }
    static void bfs(int node){
        Queue<Bacon> q = new LinkedList<>();
        total = 0;

        visited[node] = true;
        q.offer(new Bacon(node, 0));

        while (!q.isEmpty()){
            Bacon bacon = q.poll();
            total += bacon.value;

            for(int i=1; i<=N; i++){
                int num = map[bacon.num][i];
                if(num == 1 && !visited[i]){
                    visited[i] = true;
                    q.offer(new Bacon(i, bacon.value+1));
                }
            }
        }
        if(min > total){
            min = total;
            count = node;
        }
    }
}