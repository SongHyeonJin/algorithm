import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<List<Node>> list = new ArrayList<>();
    static int[] dist;
    static class Node implements Comparable<Node>{
        int depart, distance;
        public Node(int depart, int distance){
            this.depart = depart;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node o) {
            if(this.distance < o.distance)
                return -1;
            else
                return 1;
        }
    }
    private static void dijkstra(){
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Node(1, 0));
        dist[1] = 0;
        while (!priorityQueue.isEmpty()){
            Node node = priorityQueue.poll();

            for(int i=0; i<list.get(node.depart).size(); i++){
                Node next = list.get(node.depart).get(i);
                if(dist[next.depart] > dist[node.depart] + next.distance){
                    dist[next.depart] = dist[node.depart] + next.distance;
                    priorityQueue.offer(new Node(next.depart, dist[next.depart]));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }

        dist = new int[N+1];
        for(int i=1; i<=N; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        while (M --> 0){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list.get(A).add(new Node(B, C));
            list.get(B).add(new Node(A, C));
        }
        dijkstra();
        System.out.println(dist[N]);
    }
}
