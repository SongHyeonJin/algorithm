import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;
        int difference = 0;
        for(int i=1; i<=K; i++){
            count += i;
        }
        if(count > N) sb.append(-1);
        else{
            difference = K -1;
            N -= count;
            if(N%K!=0) difference++;
            sb.append(difference);
        }
        System.out.println(sb);
    }
}