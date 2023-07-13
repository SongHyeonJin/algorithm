import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;

    static class Waiting implements Comparable<Waiting>{
        int d, h, l;
        boolean deca;

        public Waiting(int d, int h, int l, boolean deca){
            this.d = d;
            this.h = h;
            this.l = l;
            this.deca = deca;
        }

        @Override
        public int compareTo(Waiting o) {
            if(this.d == o.d){
                if(this.h == o.h){
                    return this.l - o.l;
                }
                return o.h - this.h;
            }
            return o.d - this.d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());
        Queue<Waiting> queue[] = new Queue[M];
        for(int i=0; i<M; i++){
            queue[i] = new LinkedList<>();
        }
        int idx = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int l = idx;
            boolean deca = false;
            if(i == K) deca = true;
            queue[idx++].add(new Waiting(d, h, l ,deca));
            if(idx == M) idx=0;
        }
        int num = 0;
        PriorityQueue<Waiting> waiting = new PriorityQueue<>();
        for(int i=0; i<M; i++){
            if(!queue[i].isEmpty()) waiting.add(queue[i].poll());
        }
        while (true){
            Waiting wait = waiting.poll();
            if(wait.deca) break;
            else{
                if(!queue[wait.l].isEmpty()) waiting.add(queue[wait.l].poll());
            }
            num++;
        }
        System.out.print(num);
    }
}