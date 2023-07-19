import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        int count = 0;
        long sum = 0;
        while (sum < N){
            count++;
            sum += count;
        }
        if(sum > N) System.out.println(count-1);
        else System.out.println(count);
    }
}