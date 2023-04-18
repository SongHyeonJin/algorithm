import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] sick = new long[36];

        sick[0] = 1;

        for(int i=1; i<=35; i++){
            for(int j=0; j<i; j++){
                sick[i] += (sick[j]*sick[i-j-1]);
            }
        }
        System.out.println(sick[n]);
    }
}