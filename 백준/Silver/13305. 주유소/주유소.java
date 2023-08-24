import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] distance, price;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        distance = new int[N-1];
        price = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int min = price[0];
        for(int i=0; i<N-1; i++){
            if(price[i] < min) min = price[i];
            sum += (min * distance[i]);
        }
        System.out.println(sum);
    }
}