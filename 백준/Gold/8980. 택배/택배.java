import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int maxBox, pickUpBox, totalBox;
    static class Delivery implements Comparable<Delivery>{
        int depart, destination, box;
        public Delivery(int depart, int destination, int box){
            this.depart = depart;
            this.destination = destination;
            this.box = box;
        }
        @Override
        public int compareTo(Delivery o) {
            if(this.depart == o.depart) return this.destination - o.destination;
            else return this.depart - o.depart;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        Delivery boxes[] = new Delivery[M];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int depart = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int box = Integer.parseInt(st.nextToken());
            boxes[i] = new Delivery(depart, destination, box);
        }
        Arrays.sort(boxes);

        int delivery[] = new int[N+1];
        for(int i=0; i<M; i++){
            int depart = boxes[i].depart;
            int destination = boxes[i].destination;
            int box = boxes[i].box;
            maxBox = 0;
            for(int j=depart; j<destination; j++){
                maxBox = Math.max(maxBox, delivery[j]);
            }
            pickUpBox = Math.min(C-maxBox, box);
            totalBox += pickUpBox;
            for(int j=depart; j<destination; j++){
                delivery[j] += pickUpBox;
            }
        }
        System.out.println(totalBox+delivery[N]);
    }
}
