import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static int[] distance;
    static boolean check;
    static List<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        distance = new int[300001];
        lists = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<=N; i++){
            lists.add(new ArrayList<>());
            distance[i] = -1;
        }
        distance[X] = 0;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lists.get(a).add(b);
        }
        bfs();
        check = false;
        for(int i=0; i<=N; i++){
            if(distance[i] == K){
                System.out.println(i);
                check = true;
            }
        }
        if(!check) System.out.println(-1);
    }
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(X);

        while (!q.isEmpty()){
            int node = q.poll();
            for(int i=0; i< lists.get(node).size(); i++){
                int next = lists.get(node).get(i);
                if(distance[next] == -1){
                    distance[next] = distance[node] + 1;
                    q.add(next);
                }
            }
        }
    }
}