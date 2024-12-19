import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long gcd = Integer.parseInt(st.nextToken());
        long lcm = Integer.parseInt(st.nextToken());

        long tmp = gcd * lcm;
        long A = gcd;
        long B = lcm;

        for (long i = gcd; i<Math.sqrt(tmp); i++) {
            if (tmp%i==0 && foundGcd(i, tmp/i) == gcd){
                long a = i;
                long b = tmp/i;
                if(A+B > a+b){
                    A = a;
                    B = b;
                }
            }
        }
        System.out.println(A+" "+B);
    }
    static long foundGcd(long a, long b){
        return a%b == 0 ? b : foundGcd(b, a%b);
    }
}