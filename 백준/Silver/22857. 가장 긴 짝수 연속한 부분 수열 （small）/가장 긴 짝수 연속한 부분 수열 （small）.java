import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, R, L, odd, even = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(arr[0]%2 == 0) even++;
        else odd++;
        int result = even;
        while (R >= L){
            if(odd > K){
                if(arr[L]%2 == 0) even--;
                else odd--;
                L++;
            }else {
                R++;
                if(R >= N) break;
                if(arr[R]%2 == 0) even++;
                else odd++;
                result = Math.max(result, even);
            }
        }
        System.out.println(result);
    }
}
