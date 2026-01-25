import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(":");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        int gcdResult = gcd(n, m);
        
        System.out.println(n / gcdResult + ":" + m / gcdResult);
    }
    
    public static int gcd(int n, int m) {
        while (m != 0) {
            int temp = n % m;
            n = m;
            m = temp;
        }
        return n;
    }
}