import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k, idx;
    static long weight;
    static int[] bags;
    static List<Jewel> jewels;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        jewels = new ArrayList<>();
        bags = new int[k];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(m, v));
        }
        for(int i=0; i<k; i++){
            bags[i]  = Integer.parseInt(br.readLine());
        }


        Arrays.sort(bags);
        Collections.sort(jewels);
        pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));

        idx = 0;
        weight = 0;

        for(int i=0; i<k; i++){
            while (idx < n){
                Jewel jewel = jewels.get(idx);
                if(bags[i] < jewels.get(idx).weight) break;
                pq.add(jewel.price);
                idx++;
            }
            if(!pq.isEmpty()) weight += pq.poll();
        }
        System.out.println(weight);
    }
}
class Jewel implements Comparable<Jewel>{
    int weight;
    int price;

    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Jewel o) {
        return this.weight - o.weight;
    }
}