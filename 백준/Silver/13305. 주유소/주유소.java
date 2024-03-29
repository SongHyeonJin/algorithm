import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] distance, price;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        distance = new long[N-1];
        price = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            distance[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            price[i] = Long.parseLong(st.nextToken());
        }

        int sum = 0;
        long min = price[0];
        for(int i=0; i<N-1; i++){
            if(price[i] < min) min = price[i];
            sum += (min * distance[i]);
        }
        System.out.println(sum);
    }
}