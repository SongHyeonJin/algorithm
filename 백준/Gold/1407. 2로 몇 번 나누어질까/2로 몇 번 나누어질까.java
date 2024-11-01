import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        System.out.println(twoCount(b) - twoCount(a-1));
    }
    static long twoCount(long n) {
        long answer = 0;
        long div = 1;
        long beforeDiv = 0;

        while (true){
            long val = n/div;
            if(val>0) answer += val * (div-beforeDiv);
            else break;
            beforeDiv = div;
            div *= 2;
        }
        return answer;
    }
}
