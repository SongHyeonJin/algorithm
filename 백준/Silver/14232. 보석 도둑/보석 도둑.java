import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long k = Long.parseLong(br.readLine());
        int count = 0;

        for (int i = 2; i <= Math.sqrt(k); i++) {
            while (k%i==0){
                sb.append(i).append(" ");
                k /= i;
                count++;
            }
        }
        if (k != 1){
            sb.append(k);
            count++;
        }
        System.out.println(count);
        System.out.println(sb.toString());
    }
}