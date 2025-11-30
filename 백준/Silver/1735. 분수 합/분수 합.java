import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int numerator = A*D+B*C;
        int denominator = B*D;
        
        int gcd = Gcd(numerator, denominator);
        numerator /= gcd;
        sb.append(numerator).append(" ");
        
        denominator /= gcd;
        sb.append(denominator);
        
        System.out.println(sb.toString());
	}
    public static int Gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		return Gcd(b, a%b);
	}
}