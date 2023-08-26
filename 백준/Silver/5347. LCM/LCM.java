import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String[] strings = br.readLine().split(" ");
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[1]);
            
            long result = Lcm(a, b);
            
            System.out.println(result);
        }
    }
    static long Lcm(int a, int b) {
        long big,small;
        if(a>b){
            big = a;
            small = b;
        } else{
            big = b;
            small = a;
        }
        long gcd = Gcd(big, small);
        long lcm = (big * small) / gcd;
        return lcm;
    }
    static long Gcd(long big, long small) {

        if (big % small == 0) {
            return small;
        }
        return Gcd(small, big % small);

    }
}