import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());


        if(A > B){
            sb.append(A*B/findGCD(A, B)).append("\n"); 
        }else if(A < B){
            sb.append(A*B/findGCD(B, A)).append("\n");
        }else{
            sb.append(A).append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    static long findGCD(long A, long B){
        while(B != 0){
            long R = A%B;
            A = B; 
            B = R;
        }
        return A;
    }
}