import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] A = br.readLine().split(" ");
        int sum = 0;
        int result = 0;
        for(int i=0; i<A.length; i++){
            int num = Integer.parseInt(A[i]);
            num = (int) Math.pow(num, 2);
            sum += num;
        }
        result = sum%10;
        System.out.println(result);
    }
}